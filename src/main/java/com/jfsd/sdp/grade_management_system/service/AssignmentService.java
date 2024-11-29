package com.jfsd.sdp.grade_management_system.service;

import java.io.IOException;
import java.util.List;

import com.jfsd.sdp.grade_management_system.DTO.CreatAssignmentDTO;
import com.jfsd.sdp.grade_management_system.entity.AssignmentEntity;
import com.jfsd.sdp.grade_management_system.entity.CourseEntity;

public interface AssignmentService {

	AssignmentEntity findById(long id);
	
	List<AssignmentEntity> findAll();
	
	void deleteById(long id);
	
	void updateById(long id);
	
	AssignmentEntity createAssignment(CreatAssignmentDTO assignment) throws IOException;

	List<AssignmentEntity> findByCourseId(long courseId);

}
