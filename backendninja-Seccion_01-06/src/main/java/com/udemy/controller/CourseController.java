package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.model.CourseModel;
import com.udemy.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {

	private static final String COURSES_VIEW = "courses";
	private static final Log LOG = LogFactory.getLog(CourseController.class);
	
	@Autowired
	@Qualifier("courseServiceImpl")
	private CourseService courseService;
	
	//READ
	@GetMapping("/listcourses")
	public ModelAndView listAllCourses(){
		LOG.info("Call: " + "listAllCourses()");
		ModelAndView mav = new ModelAndView(COURSES_VIEW);
		mav.addObject("course", new CourseModel());
		mav.addObject("courses", courseService.listAllCourses()); 
		LOG.info("Return: " + "listAllCourses()");
		return mav;
	}
	
	//CREATE
	@PostMapping("/addcourse")
	public String addCourse(@ModelAttribute("course") CourseModel courseModel){
		LOG.info("Call: " + "addCourse()" + " -- Param: " + courseModel.toString());
		courseService.addCourse(courseModel);
		return "redirect:/courses/listcourses";
	}
	
	//UPDATE
	@PostMapping("/updatecourse")
	public String updateCourse(@ModelAttribute("course") CourseModel courseModel){
		LOG.info("Call: " + "updateCourse()" + " -- Param: " + courseModel.toString());
		courseService.updateCourse(courseModel);
		return "redirect:/courses/listcourses";
	}
	
	//DELETE
	@PostMapping("/deletecourse")
	public String deleteCourse(@ModelAttribute("course") CourseModel courseModel){
		LOG.info("Call: " + "deleteCourse()" + " -- Param: " + courseModel.toString());
		courseService.removeCourse(courseModel);
		return "redirect:/courses/listcourses";
	}

}
