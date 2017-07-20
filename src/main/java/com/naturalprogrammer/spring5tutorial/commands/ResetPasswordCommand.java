package com.naturalprogrammer.spring5tutorial.commands;

import com.naturalprogrammer.spring5tutorial.validation.Password;
import com.naturalprogrammer.spring5tutorial.validation.RetypePassword;

@RetypePassword
public class ResetPasswordCommand {
	
	@Password
	private String password;
	
	@Password
	private String retypePassword;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRetypePassword() {
		return retypePassword;
	}

	public void setRetypePassword(String retypePassword) {
		this.retypePassword = retypePassword;
	}
}
