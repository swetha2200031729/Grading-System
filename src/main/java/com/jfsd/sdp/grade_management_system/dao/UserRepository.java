 package com.jfsd.sdp.grade_management_system.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jfsd.sdp.grade_management_system.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

	UserEntity findByUsername(String username);
	
}
									