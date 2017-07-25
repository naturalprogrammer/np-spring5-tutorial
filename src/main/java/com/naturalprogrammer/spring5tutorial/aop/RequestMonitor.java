package com.naturalprogrammer.spring5tutorial.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class RequestMonitor {
	
	private static Log log = LogFactory.getLog(RequestMonitor.class);

	@Around("within(com.naturalprogrammer.spring5tutorial.controllers.*)")
	public Object wrap(ProceedingJoinPoint pjp) throws Throwable {
		
		log.info("Before handler " + pjp.getSignature().getName()
				+ ". Thread " + Thread.currentThread().getName());
		
		Object retval = pjp.proceed();
		
		log.info("Handler " + pjp.getSignature().getName()
				+ " execution successful.");
		
		return retval;
	}
}
