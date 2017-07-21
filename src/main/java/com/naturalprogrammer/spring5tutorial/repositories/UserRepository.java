package com.naturalprogrammer.spring5tutorial.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naturalprogrammer.spring5tutorial.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByEmail(String email);
	Optional<User> findByResetPasswordCode(String resetPasswordCode);
}
