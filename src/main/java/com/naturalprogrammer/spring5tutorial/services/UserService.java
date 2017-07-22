package com.naturalprogrammer.spring5tutorial.services;

import javax.mail.MessagingException;

import org.springframework.boot.context.event.ApplicationReadyEvent;

import com.naturalprogrammer.spring5tutorial.commands.ForgotPasswordCommand;
import com.naturalprogrammer.spring5tutorial.commands.UserCommand;
import com.naturalprogrammer.spring5tutorial.domain.User;

public interface UserService {

	void signup(UserCommand userCommand);
	void afterApplicationReady(ApplicationReadyEvent event);
	void verify(String verificationCode);
	void resendVerificationMail(User user) throws MessagingException;
	void forgotPassword(ForgotPasswordCommand forgotPasswordCommand);
	void resetPassword(String resetPasswordCode, String password);
	User fetchById(Long userId);
	void update(User oldUser, UserCommand userCommand);
}
