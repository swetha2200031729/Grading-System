package com.jfsd.sdp.grade_management_system.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jfsd.sdp.grade_management_system.entity.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, Long>{

}
