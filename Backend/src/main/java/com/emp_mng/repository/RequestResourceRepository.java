package com.emp_mng.repository;

import java.util.Optional;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.emp_mng.entities.RequestResources;

@Repository
public interface RequestResourceRepository extends JpaRepository<RequestResources,Integer>{

	  @Query("SELECT r FROM RequestResources r WHERE r.employeeId = :employeeId")
	    Optional<RequestResources> findByEmployeeId(int employeeId);
	  
	  List<RequestResources> findByStatus(String status);
	  
	  @Query("SELECT r FROM RequestResources r WHERE r.employeeId = :employeeId AND r.status = 'approved'")
	    List<RequestResources> findApprovedRequestsByEmployeeId(@Param("employeeId") int employeeId);
	  @Query("SELECT r FROM RequestResources r WHERE r.managerId = :managerId AND r.status = 'approved'")
	    List<RequestResources> findApprovedRequestsByManagerId(@Param("managerId") int managerId); 
	
	  
	
}
