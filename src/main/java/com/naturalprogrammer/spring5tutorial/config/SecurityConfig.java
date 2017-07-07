package com.naturalprogrammer.spring5tutorial.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// @formatter:off
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
			.authorizeRequests()
				.anyRequest().authenticated()
				.and()
			.formLogin().loginPage("/login").permitAll()
			.and().logout().permitAll();
	}
	// @formatter:on
}
