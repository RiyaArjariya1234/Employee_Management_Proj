package com.emp_mng.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.emp_mng.entities.AssignProject;
import com.emp_mng.entities.Project;
//import com.emp2.dto.ProjectDTO;
import java.util.List;

@Repository
public interface AssignProjectRepository extends JpaRepository<AssignProject, Integer> { 
	
	boolean existsByProject(Project project);
	List<AssignProject> findByUser_UserId(int userId);
	


}

