package com.naturalprogrammer.spring5tutorial.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// @formatter:off
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
			.authorizeRequests()
				.mvcMatchers(HttpMethod.GET, "/").permitAll()
				.mvcMatchers("/signup",
						"/forgot-password",
						"/reset-password/*").permitAll()
				.mvcMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated()
				.and()
			.formLogin().loginPage("/login").permitAll()
			.and().logout().permitAll();
	}
	// @formatter:on
}
