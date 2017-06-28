package com.naturalprogrammer.spring5tutorial.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/signup")
public class SignupController {
	
	private static Log log = LogFactory.getLog(SignupController.class);

	@GetMapping
	public String signup() {
		
		return "signup";
	}	

	@PostMapping
	public String doSignup(
			@RequestParam String email,		
			@RequestParam String name,		
			@RequestParam String password) {
		
		log.info("Email: " + email + "; Name: " +
				name + "; Password:" + password);
		
		return "redirect:/";
	}	
}
