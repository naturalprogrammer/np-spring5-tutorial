package com.naturalprogrammer.spring5tutorial.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.naturalprogrammer.spring5tutorial.commands.UserCommand;
import com.naturalprogrammer.spring5tutorial.domain.User;
import com.naturalprogrammer.spring5tutorial.domain.User.Role;
import com.naturalprogrammer.spring5tutorial.repositories.UserRepository;

@Service("userService")
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {

		this.userRepository = userRepository;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void signup(UserCommand userCommand) {
		
		User user = userCommand.toUser();
		user.getRoles().add(Role.UNVERIFIED);
		
		userRepository.save(user);
	}
}
