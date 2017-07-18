package com.naturalprogrammer.spring5tutorial.services;

import java.util.Optional;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.naturalprogrammer.spring5tutorial.commands.ForgotPasswordCommand;
import com.naturalprogrammer.spring5tutorial.commands.UserCommand;
import com.naturalprogrammer.spring5tutorial.domain.User;
import com.naturalprogrammer.spring5tutorial.domain.User.Role;
import com.naturalprogrammer.spring5tutorial.mail.MailSender;
import com.naturalprogrammer.spring5tutorial.repositories.UserRepository;
import com.naturalprogrammer.spring5tutorial.utils.MyUtils;

@Service("userService")
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class UserServiceImpl implements UserService {
	
	private static Log log = LogFactory.getLog(UserServiceImpl.class);
	
	@Value("${application.admin.email:admin@example.com}")
	private String adminEmail;
	
	@Value("${application.admin.name:First Admin}")
	private String adminName;

	@Value("${application.admin.password:password}")
	private String adminPassword;

	private PasswordEncoder passwordEncoder;
	private UserRepository userRepository;
	private MailSender mailSender;
	private String applicationUrl;
	
	public UserServiceImpl(UserRepository userRepository,
			PasswordEncoder passwordEncoder,
			MailSender mailSender,
			@Value("${applicationUrl}") String applicationUrl) {

		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.mailSender = mailSender;
		this.applicationUrl = applicationUrl;
	}
	
	@PostConstruct
	public void init() {
		
		log.info("Inside Post construct");
	}
	
	@Override
	@EventListener
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void afterApplicationReady(ApplicationReadyEvent event) {
		
		User user = new User();
		
		if (!userRepository.findByEmail(adminEmail).isPresent()) {

			user.setEmail(adminEmail);
			user.setName(adminName);
			user.setPassword(passwordEncoder.encode(adminPassword));
			user.getRoles().add(Role.ADMIN);
			
			userRepository.save(user);
		}		
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void signup(UserCommand userCommand) {
		
		User user = userCommand.toUser();
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.getRoles().add(Role.UNVERIFIED);
		user.setVerificationCode(UUID.randomUUID().toString());
		
		userRepository.save(user);
		MyUtils.afterCommit(() -> {
			
			MyUtils.login(user);
			try {
				
				sendVerificationMail(user);
				
			} catch (MessagingException e) {
				
				log.warn("Sending verification mail to "
						+ user.getEmail() + " failed", e);
			}
		});
	}

	private void sendVerificationMail(User user) throws MessagingException {
		
		String verificationLink = applicationUrl + "/users/" +
				user.getVerificationCode() + "/verify";
		
		mailSender.send(user.getEmail(), MyUtils.getMessage("verifySubject"),
				MyUtils.getMessage("verifyBody", verificationLink));
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void verify(String verificationCode) {
		
		User currentUser = MyUtils.currentUser().get();
		
		User user = userRepository.getOne(currentUser.getId());
		
		MyUtils.validate(user.getRoles().contains(Role.UNVERIFIED), "alreadyVerified");
		MyUtils.validate(verificationCode.equals(user.getVerificationCode()), "wrongVerificationCode");

		user.getRoles().remove(Role.UNVERIFIED);
		user.setVerificationCode(null);
		
		userRepository.save(user);
		MyUtils.afterCommit(() -> MyUtils.login(user));
	}

	@Override
	public void resendVerificationMail(User user) throws MessagingException {
		
		MyUtils.validate(user != null, "userNotFound");
		MyUtils.validate(isAdminOrSelfLoggedIn(user), "notPermitted");
		MyUtils.validate(user.getRoles().contains(Role.UNVERIFIED),
				"alreadyVerified");
		
		sendVerificationMail(user);		
	}

	private boolean isAdminOrSelfLoggedIn(User user) {
		
		Optional<User> currentUser = MyUtils.currentUser();
		
		if (!currentUser.isPresent())
			return false;
		
		User cUser = currentUser.get();
		
		if (cUser.getRoles().contains(Role.ADMIN))
			return true;
		
		if (cUser.getId().equals(user.getId()))
			return true;

		return false;
	}

	@Override
	public void forgotPassword(ForgotPasswordCommand forgotPasswordCommand) {
		log.info("Resetting password for " + forgotPasswordCommand.getEmail());
	}
}
