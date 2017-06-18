package com.naturalprogrammer.spring5tutorial.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naturalprogrammer.spring5tutorial.mail.MailSender;

@RestController
public class MailController {
	
	@Autowired
	private MailSender mailSender;

	@RequestMapping("/mail")
	public String mail() {
		
		mailSender.send("mail@example.com", "A test mail", "Body of the test mail");
		
		return "Mail sent";
	}
}
