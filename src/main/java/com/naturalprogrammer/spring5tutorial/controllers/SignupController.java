package com.naturalprogrammer.spring5tutorial.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.naturalprogrammer.spring5tutorial.commands.UserCommand;
import com.naturalprogrammer.spring5tutorial.commands.UserCommand.SignupValidation;
import com.naturalprogrammer.spring5tutorial.services.UserService;
import com.naturalprogrammer.spring5tutorial.utils.MyUtils;

@Controller
@RequestMapping("/signup")
public class SignupController {
	
	private static Log log = LogFactory.getLog(SignupController.class);
	
	private UserService userService;
	
	public SignupController(UserService userService) {

		this.userService = userService;
	}

	@GetMapping
	public String signup(Model model) {
		
		model.addAttribute("user", new UserCommand());
		return "signup";
	}	

	@PostMapping
	public String doSignup(
			@Validated(SignupValidation.class)
			@ModelAttribute("user") UserCommand user,
			BindingResult result,
			RedirectAttributes redirectAttributes) {
		
		if (result.hasErrors())
			return "signup";
		
		userService.signup(user);
		MyUtils.flash(redirectAttributes, "success", "signupSuccess");
		return "redirect:/";
	}	
}
