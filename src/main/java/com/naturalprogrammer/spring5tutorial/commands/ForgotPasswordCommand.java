package com.naturalprogrammer.spring5tutorial.commands;

import com.naturalprogrammer.spring5tutorial.validation.EmailExists;

public class ForgotPasswordCommand {
	
	@EmailExists
	private String email;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
