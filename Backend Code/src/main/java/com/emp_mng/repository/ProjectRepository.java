package com.emp_mng.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp_mng.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
	
	
}
