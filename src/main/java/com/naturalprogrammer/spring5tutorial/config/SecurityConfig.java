package com.naturalprogrammer.spring5tutorial.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private UserDetailsService userDetailsService;
	private String rememberMeKey;
	
	public SecurityConfig(UserDetailsService userDetailsService,
			@Value("${rememberMeKey}") String rememberMeKey) {

		this.userDetailsService = userDetailsService;
		this.rememberMeKey = rememberMeKey;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}

	// @formatter:off
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
			.authorizeRequests()
				.mvcMatchers(HttpMethod.GET, "/",
						"/css/**", "/js/**", "/images/**",
						"/actuator/health", "/actuator/info",
						"/users/*").permitAll()
				.mvcMatchers("/signup",
						"/forgot-password",
						"/reset-password/*").permitAll()
				.mvcMatchers("/admin/**", "/actuator/**").hasRole("ADMIN")
				.anyRequest().authenticated()
				.and()
			.formLogin().loginPage("/login").permitAll()
			.and().logout().permitAll()
			.and().rememberMe()
				.key(rememberMeKey)
				.rememberMeServices(new TokenBasedRememberMeServices(rememberMeKey,
						userDetailsService));
	}
	// @formatter:on
}
