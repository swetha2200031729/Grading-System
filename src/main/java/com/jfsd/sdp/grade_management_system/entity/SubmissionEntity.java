package com.jfsd.sdp.grade_management_system.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SubmissionEntity {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	private AssignmentEntity assignmentEntity;
	
	@ManyToOne
	private UserEntity submittedBy;
	
	@CreationTimestamp
	private LocalDateTime submittedOn;
	
	@OneToMany(mappedBy = "submission")
	private SubmissionEntity submitted;
}
