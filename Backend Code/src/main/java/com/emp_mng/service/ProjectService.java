package com.emp_mng.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp_mng.dto.ProjectDTO;
import com.emp_mng.entities.Project;
import com.emp_mng.repository.ProjectRepository;

@Service
public class ProjectService {
	
	    @Autowired
	    private ProjectRepository projectRepository;

	    public Project saveProject(ProjectDTO projectDTO) {
	    	Project project = new Project();
	        project.setName(projectDTO.getName());
	        project.setDescription(projectDTO.getDescription());

	        return projectRepository.save(project);
	    }

	    public List<Project> getAllProjects() {
	        return projectRepository.findAll();
	    }

}
