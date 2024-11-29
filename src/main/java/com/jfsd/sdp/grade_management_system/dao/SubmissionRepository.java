package com.jfsd.sdp.grade_management_system.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jfsd.sdp.grade_management_system.entity.AssignmentEntity;
import com.jfsd.sdp.grade_management_system.entity.SubmissionEntity;
import com.jfsd.sdp.grade_management_system.entity.UserEntity;

public interface SubmissionRepository extends JpaRepository<SubmissionEntity , Long>{
	SubmissionEntity findBySubmittedByAndAssignmentEntity(UserEntity submittedBy, AssignmentEntity assignmentEntity);
}
