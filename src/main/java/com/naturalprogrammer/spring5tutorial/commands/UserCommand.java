package com.naturalprogrammer.spring5tutorial.commands;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.naturalprogrammer.spring5tutorial.domain.User;
import com.naturalprogrammer.spring5tutorial.validation.UniqueEmail;

public class UserCommand {
	
	@UniqueEmail
	private String email;
	
	@NotBlank
	@Size(min=1, max=100)
	private String name;
	
	@NotBlank
	@Size(min=6, max=32)
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public User toUser() {
		
		User user = new User();
		
		user.setEmail(email);
		user.setName(name);
		user.setPassword(password);
		
		return user;
	}
}
