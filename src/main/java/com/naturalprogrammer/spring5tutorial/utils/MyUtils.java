package com.naturalprogrammer.spring5tutorial.utils;

import java.util.Optional;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.naturalprogrammer.spring5tutorial.domain.User;

@Component
public class MyUtils {
	
	private static MessageSource messageSource;
	
	public MyUtils(MessageSource messageSource) {
		MyUtils.messageSource = messageSource;
	}

	public static String getMessage(String messageKey, Object... args) {
		
		return messageSource.getMessage(messageKey, args,
				LocaleContextHolder.getLocale());
	}
	
	public static void flash(RedirectAttributes redirectAttributes,
			String flashKind, String flashMessageCode) {

		redirectAttributes.addFlashAttribute("flashMessage",
				getMessage(flashMessageCode));
		
		redirectAttributes.addFlashAttribute("flashKind", flashKind);
	}
	
	public static Optional<User> currentUser() {
		
		Authentication auth = SecurityContextHolder
				.getContext().getAuthentication();
		
		if (auth != null) {
			
			Object principal = auth.getPrincipal();
			
			if (principal instanceof User)
				return Optional.of((User) principal);
		}
		
		return Optional.empty();
	}
	
	public static void login(UserDetails user) {
		
		Authentication auth = new UsernamePasswordAuthenticationToken(
				user, null, user.getAuthorities());
		
		SecurityContextHolder.getContext().setAuthentication(auth);
	}
	
	public static void logout() {
		SecurityContextHolder.getContext().setAuthentication(null);
	}
	
	public static void afterCommit(Runnable runnable) {
		
		TransactionSynchronizationManager.registerSynchronization(
				new TransactionSynchronizationAdapter() {
				    @Override
				    public void afterCommit() {
				    	
						runnable.run();
				    }
			    }
			);	
	}
	
	public static void validate(boolean valid, String messageKey, Object ... messageArgs) {
		
		if (!valid)
			throw new RuntimeException(MyUtils.getMessage(messageKey, messageArgs));
	}
}
