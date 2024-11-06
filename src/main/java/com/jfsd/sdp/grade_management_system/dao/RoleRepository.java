package com.jfsd.sdp.grade_management_system.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jfsd.sdp.grade_management_system.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long>{
	
	RoleEntity findByRoleName(String roleName);
	
}