package com.jfsd.sdp.grade_management_system.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = true)
	private String userName;
	
	private String password;
	
	private String firstName;
	
	private String lastName;
	
	@Column(unique  = true)
	private String email;
	
	private LocalDate dateOfBirth;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private RoleEntity roleEntity;
	
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@OneToMany(mappedBy="createdBy")
	private List<AssignmentEntity> createdAssignments = new ArrayList<>();
	
	@OneToMany(mappedBy = "submittedBy",cascade = CascadeType.REMOVE)
	private  List<SubmissionEntity> submissions = new ArrayList<>();
	
	@OneToMany(mappedBy = "gradedBy",cascade = CascadeType.REMOVE)
	private List<GradeEntity> grades = new ArrayList<>();

}
