package com.jfsd.sdp.grade_management_system.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class GradeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	private UserEntity gradedBy;
	
	@ManyToOne
	private SubmissionEntity submission;
	
	private int grade;
	
	@CreationTimestamp
	private LocalDateTime gradedOn;
	
	private String feedback;
	
	
		
}
