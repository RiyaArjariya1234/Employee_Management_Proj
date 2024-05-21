package com.emp_mng.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp_mng.entities.AssignProject;
import com.emp_mng.entities.Project;

//import net.bytebuddy.implementation.bind.annotation.AllArguments.Assignment;

public interface AssignProjectRepository extends JpaRepository<AssignProject, Integer> { 
	boolean existsByProject(Project project);

}
