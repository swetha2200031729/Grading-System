package com.jfsd.sdp.grade_management_system.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateCourseRegistrationDTO {
	
	@JsonProperty("studentId")
	private long studentId;
	
	@JsonProperty("courseId")
	private long CourseId;
	
     	
	
}		