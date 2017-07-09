package com.naturalprogrammer.spring5tutorial.utils;

import java.util.Optional;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
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
}
