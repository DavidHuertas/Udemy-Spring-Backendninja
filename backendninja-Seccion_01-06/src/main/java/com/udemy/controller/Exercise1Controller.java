package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.service.Exercise1Service;

@Controller
@RequestMapping("/exercise1")
public class Exercise1Controller {
	
	private static final String EXERCISE1_VIEW = "exercise1";
	private static final Log LOG = LogFactory.getLog(Exercise1Controller.class);
	
	@Autowired
	@Qualifier("exercise1Service")
	private Exercise1Service exercise1Service;
	
	//EL MÉTODO 1 REDIRIGE AL MÉTODO 2
	@GetMapping("/method1")
	public RedirectView method1(){
		return new RedirectView("/exercise1/method2");
	}
	
	//EL MÉTODO 2 EJECUTA EL SERVICIO
	@GetMapping("/method2")
	public ModelAndView method2(){
		long startTime = System.currentTimeMillis();
		exercise1Service.logMessage();
		ModelAndView mav = new ModelAndView(EXERCISE1_VIEW);
		mav.addObject("message", "mensaje");
		LOG.info("METHOD2 -- TIME REQUEST -- " + (System.currentTimeMillis() - startTime) + "ms");
		return mav;
	}

}
