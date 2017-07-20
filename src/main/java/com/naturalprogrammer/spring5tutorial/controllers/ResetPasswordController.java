package com.naturalprogrammer.spring5tutorial.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.naturalprogrammer.spring5tutorial.commands.ResetPasswordCommand;
import com.naturalprogrammer.spring5tutorial.services.UserService;

@Controller
@RequestMapping("/reset-password/{resetPasswordCode}")
public class ResetPasswordController {
	
	private static Log log = LogFactory.getLog(ResetPasswordController.class);
	
	private UserService userService;
	
	public ResetPasswordController(UserService userService) {

		this.userService = userService;
	}

	@GetMapping
	public String resetPassword(Model model) {
		
		model.addAttribute(new ResetPasswordCommand());
		return "reset-password";
	}	

	@PostMapping
	public String doResetPassword(@Validated ResetPasswordCommand resetPasswordCommand,
			BindingResult result,
			RedirectAttributes redirectAttributes) {
		
		if (result.hasErrors())
			return "reset-password";
		
		//userService.signup(user);
		//MyUtils.flash(redirectAttributes, "success", "signupSuccess");
		return "redirect:/";
	}	
}
