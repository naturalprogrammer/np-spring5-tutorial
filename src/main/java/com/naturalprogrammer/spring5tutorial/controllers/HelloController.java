package com.naturalprogrammer.spring5tutorial.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello(Model model) {
		
		model.addAttribute("name", "Sanjay");
		
		return "hello";
	}
	
//	@RequestMapping("/hello")
//	public ModelAndView hello() {
//		
//        ModelAndView mav = new ModelAndView("hello"); // the logical view name
//		mav.addObject("name", "Sanjay");
//		return mav;
//	}
}
