package com.jfsd.sdp.grade_management_system.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jfsd.sdp.grade_management_system.entity.DeadLineEntity;

@Repository
public interface DeadLineRepository extends JpaRepository<DeadLineEntity, Long>{

}
