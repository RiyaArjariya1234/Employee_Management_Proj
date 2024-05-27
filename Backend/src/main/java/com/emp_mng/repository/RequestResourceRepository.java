package com.emp_mng.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.emp_mng.entities.RequestResources;

@Repository
public interface RequestResourceRepository extends JpaRepository<RequestResources,Integer>{

	  @Query("SELECT r FROM RequestResources r WHERE r.employeeId = :employeeId")
	    Optional<RequestResources> findByEmployeeId(int employeeId);
	
}
