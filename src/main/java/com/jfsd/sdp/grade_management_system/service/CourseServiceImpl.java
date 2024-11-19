package com.jfsd.sdp.grade_management_system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfsd.sdp.grade_management_system.dao.CourseRepository;
import com.jfsd.sdp.grade_management_system.entity.CourseEntity;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public CourseEntity findCourseByCourseName(String name) {
		courseRepository.findByCourseName(name);
		return null;
		
	}

	@Override
	public CourseEntity createCourse(String courseName) {
		CourseEntity course = new CourseEntity();
		course.setCourseName(courseName);
	     return courseRepository.save(course);
		
	}

	

	@Override
	public List<CourseEntity> findAll() {
		return courseRepository.findAll();
	
	}

	@Override
	public void deleteById(long id) {
		
		courseRepository.deleteById(id);
		
	}

	@Override
	public CourseEntity findById(long id) {
		
		Optional<CourseEntity> course =  courseRepository.findById(id);
		
		CourseEntity theCourse = null;
		
		if(course.isPresent()) {
			theCourse = course.get();
		}
		else {
			throw new RuntimeException("Did not find user id - " + theCourse);
		}
		return theCourse;
		
		
	} 
	
	
	
	
}
