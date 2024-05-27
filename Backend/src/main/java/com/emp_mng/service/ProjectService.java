package com.emp_mng.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp_mng.dto.ProjectDTO;
import com.emp_mng.entities.Project;
import com.emp_mng.repository.ProjectRepository;
import com.emp_mng.repository.AssignProjectRepository;
import com.emp_mng.entities.AssignProject;
import java.util.stream.Collectors;


@Service
public class ProjectService {
	
	    @Autowired
	    private ProjectRepository projectRepository;
	    @Autowired
	    private AssignProjectRepository assignProjectRepository;

	    public Project saveProject(ProjectDTO projectDTO) {
	    	Project project = new Project();
	        project.setName(projectDTO.getName());
	        project.setDescription(projectDTO.getDescription());

	        return projectRepository.save(project);
	    }

	    public List<Project> getAllProjects() {
	        return projectRepository.findAll();
	    }
	   
      public List<Project> getProjectsByUserId(int userId) {
	        List<AssignProject> projectAssigns = assignProjectRepository.findByUser_UserId(userId);
	        return projectAssigns.stream()
	                             .map(AssignProject::getProject)
	                             .collect(Collectors.toList());
	    }

}

