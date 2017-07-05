package com.naturalprogrammer.spring5tutorial.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitApp implements CommandLineRunner {

	private static Log log = LogFactory.getLog(InitApp.class);
	
	@Override
	public void run(String... arg0) throws Exception {
		log.info("Inside InitApp");
	}
}
