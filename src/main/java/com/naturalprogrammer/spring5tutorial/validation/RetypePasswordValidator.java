package com.naturalprogrammer.spring5tutorial.validation;

import java.util.Objects;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import com.naturalprogrammer.spring5tutorial.commands.ResetPasswordCommand;
import com.naturalprogrammer.spring5tutorial.repositories.UserRepository;

@Component
public class RetypePasswordValidator
	implements ConstraintValidator<RetypePassword, ResetPasswordCommand> {
	
	private UserRepository userRepository;
	
	public RetypePasswordValidator(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void initialize(RetypePassword arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(ResetPasswordCommand resetPasswordCommand, ConstraintValidatorContext arg1) {
		
		return Objects.equals(resetPasswordCommand.getPassword(),
				resetPasswordCommand.getRetypePassword());
	}
}
