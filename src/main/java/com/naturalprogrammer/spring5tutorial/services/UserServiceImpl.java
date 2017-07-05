package com.naturalprogrammer.spring5tutorial.services;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.naturalprogrammer.spring5tutorial.commands.UserCommand;
import com.naturalprogrammer.spring5tutorial.domain.User;
import com.naturalprogrammer.spring5tutorial.domain.User.Role;
import com.naturalprogrammer.spring5tutorial.repositories.UserRepository;

@Service("userService")
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class UserServiceImpl implements UserService {
	
	private static Log log = LogFactory.getLog(UserServiceImpl.class);

	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {

		this.userRepository = userRepository;
	}
	
	@PostConstruct
	public void init() {
		
		log.info("Inside Post construct");
	}
	
	@Override
	@EventListener
	public void afterApplicationReady(ApplicationReadyEvent event) {
		
		log.info("Inside afterApplicationReady");
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void signup(UserCommand userCommand) {
		
		User user = userCommand.toUser();
		user.getRoles().add(Role.UNVERIFIED);
		
		userRepository.save(user);
	}
}
