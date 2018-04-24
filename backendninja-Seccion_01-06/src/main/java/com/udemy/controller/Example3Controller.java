package com.udemy.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.model.Person;

@Controller
@RequestMapping("/example3")
public class Example3Controller {

	private static final String FORM_VIEW = "form";
	private static final String RESULT_VIEW = "result";

	private static final Log LOGGER = LogFactory.getLog(Example3Controller.class);
	
	//REDIRIGIR /example3 A /example3/showform POR DEFECTO
	/*
	@GetMapping("/")
	public String redirect(){
		return "redirect:/example3/showform";
	}
	*/
	
	//OTRA FORMA DE
	//REDIRIGIR /example3 A /example3/showform POR DEFECTO
	@GetMapping("/")
	public RedirectView redirect(){
		return new RedirectView("/example3/showform");
	}
	
	@GetMapping("/showform")
	public String showForm(Model model){
		model.addAttribute("person", new Person());
//		int i = 6 / 0;//PARA CHECKEAR INTERNAL SERVER ERROR 500
		LOGGER.info("INFO TRACE");
		LOGGER.warn("WARNING TRACE");
		LOGGER.error("ERROR TRACE");
		LOGGER.debug("DEBUG");//ESTA ÚLTIMA TRAZA NO SE MUESTRA EN MODO NORMAL, SÓLO EN MODO DEBUG
		return FORM_VIEW;
	}

	@PostMapping("/addperson")
	public ModelAndView addPerson(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult){
		ModelAndView mav = new ModelAndView();
		if (bindingResult.hasErrors()){
			mav.setViewName(FORM_VIEW);
		}else{
			mav.setViewName(RESULT_VIEW);
			mav.addObject("person", person);
		}
		LOGGER.info("METHOD: 'addPerson' -- PARAMS: '" + person + "'");
		LOGGER.info("TEMPLATE: '"+ RESULT_VIEW + "' -- DATA: '" + person + "'");
		return mav;
	}
}
