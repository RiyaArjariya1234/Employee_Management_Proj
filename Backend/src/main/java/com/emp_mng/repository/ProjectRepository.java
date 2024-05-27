package com.emp_mng.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emp_mng.entities.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
	
	
}

