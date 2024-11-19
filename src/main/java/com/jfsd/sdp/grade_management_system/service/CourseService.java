package com.jfsd.sdp.grade_management_system.service;

import java.util.List;

import com.jfsd.sdp.grade_management_system.entity.AssignmentEntity;
import com.jfsd.sdp.grade_management_system.entity.CourseEntity;

public interface CourseService {

	CourseEntity findCourseByCourseName(String name);
	
	CourseEntity createCourse(String courseName);
	
	CourseEntity findById(long id);
	
	List<CourseEntity> findAll();
	
	void deleteById(long id);
	
	
}
