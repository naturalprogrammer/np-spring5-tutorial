package com.naturalprogrammer.spring5tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class NpSpring5TutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(NpSpring5TutorialApplication.class, args);
	}
}
