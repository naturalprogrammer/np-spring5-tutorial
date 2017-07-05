package com.naturalprogrammer.spring5tutorial.services;

import org.springframework.boot.context.event.ApplicationReadyEvent;

import com.naturalprogrammer.spring5tutorial.commands.UserCommand;

public interface UserService {

	void signup(UserCommand userCommand);
	void afterApplicationReady(ApplicationReadyEvent event);
}
