package com.udemy.service;

import java.util.List;

import com.udemy.entity.Course;
import com.udemy.model.CourseModel;

public interface CourseService {

	public abstract List<CourseModel> listAllCourses();
	public abstract Course addCourse(CourseModel courseModel);
	public abstract int removeCourse(CourseModel courseModel);
	public abstract Course updateCourse(CourseModel courseModel);
	
}
