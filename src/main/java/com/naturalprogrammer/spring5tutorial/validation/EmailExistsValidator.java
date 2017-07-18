package com.naturalprogrammer.spring5tutorial.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import com.naturalprogrammer.spring5tutorial.repositories.UserRepository;

@Component
public class EmailExistsValidator
	implements ConstraintValidator<EmailExists, String> {
	
	private UserRepository userRepository;
	
	public EmailExistsValidator(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void initialize(EmailExists arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext arg1) {
		
		return userRepository.findByEmail(email).isPresent();
	}
}
