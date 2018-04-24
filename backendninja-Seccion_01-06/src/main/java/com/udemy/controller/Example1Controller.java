package com.udemy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.component.ExampleComponent;
import com.udemy.service.ExampleService;

@Controller
@RequestMapping("/example")
public class Example1Controller {
	
	public static final String EXAMPLE_VIEW = "example";//NOMBRE DEL HTML
	
	@Autowired
	@Qualifier("exampleService")
	private ExampleService exampleService;
	
	@Autowired
	@Qualifier("exampleComponent")
	private ExampleComponent exampleComponent;
	
	//Primera forma
//ESTA ANOTACIÓN ESTÁ OBSOLETA, GetMapping es más directa
//	@RequestMapping(value="/exampleString", method=RequestMethod.GET)
	@GetMapping("/exampleString")
	public String exampleString(Model model){
		exampleComponent.sayHello();
		model.addAttribute("people", exampleService.getListPeople());//DONDE name ES EL ATRIBUTO INTRODUCIDO EN LA PLANTILLA example.html DENTRO DEL ${}
		return EXAMPLE_VIEW;
	}
	
	//Segunda forma
//	@RequestMapping(value="/exampleMAV", method=RequestMethod.GET)
	@GetMapping("/exampleMAV")
	public ModelAndView exampleMAV(){
		ModelAndView mav= new ModelAndView("example");
		mav.addObject("people", exampleService.getListPeople());//DONDE name ES EL ATRIBUTO INTRODUCIDO EN LA PLANTILLA example.html DENTRO DEL ${}
		return mav;
	}
}
