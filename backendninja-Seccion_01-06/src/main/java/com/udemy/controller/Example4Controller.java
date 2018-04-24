package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example4")
public class Example4Controller {

	public static final String EXAMPLE4_VIEW = "404";
	
	@GetMapping("/error404MAV")
	public ModelAndView example4Mav(){
		return new ModelAndView(EXAMPLE4_VIEW);
	}
	
}
