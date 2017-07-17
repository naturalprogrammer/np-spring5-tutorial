package com.naturalprogrammer.spring5tutorial.controllers;

import javax.mail.MessagingException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.naturalprogrammer.spring5tutorial.domain.User;
import com.naturalprogrammer.spring5tutorial.services.UserService;
import com.naturalprogrammer.spring5tutorial.utils.MyUtils;

@Controller
@RequestMapping("/users")
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/{verificationCode}/verify")
	public String verify(@PathVariable String verificationCode,
			RedirectAttributes redirectAttributes) {
		
		userService.verify(verificationCode);
		MyUtils.flash(redirectAttributes, "success", "verificationSuccessful");
		return "redirect:/";
	}
	
	@GetMapping("/{userId}/resend-verification-mail")
	public String resendVerificationMail(@PathVariable("userId") User user,
			RedirectAttributes redirectAttributes) throws MessagingException {
		
		userService.resendVerificationMail(user);
		MyUtils.flash(redirectAttributes, "success", "verificationMailResent");
		return "redirect:/";
	}
}
