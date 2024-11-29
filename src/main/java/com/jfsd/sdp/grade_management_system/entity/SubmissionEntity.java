package com.jfsd.sdp.grade_management_system.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
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
	
	@Lob 
	@Column(columnDefinition = "LONGBLOB")
	private byte[] submissionAnsFile;
	
}
