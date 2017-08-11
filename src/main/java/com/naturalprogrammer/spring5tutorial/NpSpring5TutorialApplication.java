package com.naturalprogrammer.spring5tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableSpringDataWebSupport
@EnableAsync
public class NpSpring5TutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(NpSpring5TutorialApplication.class, args);
	}
}
