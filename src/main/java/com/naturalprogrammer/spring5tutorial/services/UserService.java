package com.naturalprogrammer.spring5tutorial.services;

import com.naturalprogrammer.spring5tutorial.commands.UserCommand;

public interface UserService {

	void signup(UserCommand userCommand);
}
