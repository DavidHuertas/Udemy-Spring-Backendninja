package com.udemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example1bis")
public class Example1BisController {

	public static final String EXAMPLE1_BIS_VIEW = "example1bis";//NOMBRE DEL HTML
	
	//Primera forma: útil para redirecciones, donde hay que insertar pocos datos o ninguno
//	@RequestMapping(value="/exampleTwoString", method=RequestMethod.GET)
	@GetMapping("/example1bisString")
	public String exampleOneBisString(){
		return EXAMPLE1_BIS_VIEW;
	}
	
	//Segunda forma: útil para insertar muchos datos en las plantillas
//	@RequestMapping(value="/exampleTwoMAV", method=RequestMethod.GET)
	@GetMapping("/example1bisMAV")
	public ModelAndView exampleOneBisMAV(){
		return new ModelAndView(EXAMPLE1_BIS_VIEW);
	}
}
