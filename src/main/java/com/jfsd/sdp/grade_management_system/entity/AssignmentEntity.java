package com.jfsd.sdp.grade_management_system.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AssignmentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = true)
	private String assignmentName;
	
	@ManyToOne
	private UserEntity createdBy;
	
	private String assignmentDescription;
	
	@ManyToOne
	private CourseEntity courseEntity;
	
	private LocalDateTime deadLine;
	
	@OneToMany(mappedBy = "assignmentEntity")
	private List<SubmissionEntity> submissions = new ArrayList<>();
}
