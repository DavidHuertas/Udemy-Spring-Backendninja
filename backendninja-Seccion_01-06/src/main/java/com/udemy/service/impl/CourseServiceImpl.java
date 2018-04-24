package com.udemy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.converter.CourseConverter;
import com.udemy.entity.Course;
import com.udemy.model.CourseModel;
import com.udemy.repository.CourseJpaRepository;
import com.udemy.service.CourseService;

@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService{

	private static final Log LOG = LogFactory.getLog(CourseServiceImpl.class);

	@Autowired
	@Qualifier("courseConverter")
	private CourseConverter courseConverter;

	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaRepository courseJpaRepository;
	
	@Override
	public List<CourseModel> listAllCourses() {
		LOG.info("Call: " + "listAllCourses()");
		List<CourseModel> courseModelList = new ArrayList<CourseModel>();
		List<Course> courseList = courseJpaRepository.findAll();
		for (Course course : courseList){
			CourseModel courseModel = courseConverter.entity2model(course);
			courseModelList.add(courseModel);
		}
		LOG.info("Return: " + "listAllCourses()");
		return courseModelList;
	}

	@Override
	public Course addCourse(CourseModel courseModel) {
		LOG.info("Call: " + "addCourse()");
		return courseJpaRepository.save(courseConverter.model2entity(courseModel));
	}

	@Override
	public int removeCourse(CourseModel courseModel) {
		courseJpaRepository.delete(courseConverter.model2entity(courseModel).getId());
		return 0;
	}

	@Override
	public Course updateCourse(CourseModel courseModel) {
		return courseJpaRepository.save(courseConverter.model2entity(courseModel));
	}

}
