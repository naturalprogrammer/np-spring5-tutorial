package com.naturalprogrammer.spring5tutorial.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.naturalprogrammer.spring5tutorial.utils.MyUtils;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello(Model model) {
		
		model.addAttribute("name",
				MyUtils.getMessage("text",
						"http://below18.example.com",
						"http://above18.example.com"));
		
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
