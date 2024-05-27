package com.emp_mng.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.emp_mng.dto.ProjectDTO;
import com.emp_mng.entities.Project;
import com.emp_mng.service.ProjectService;

@RestController
@CrossOrigin
@RequestMapping("/api/project")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@PostMapping("/addProject")
	public ResponseEntity<Project> addProject(@RequestBody ProjectDTO projectDTO)
	{
		Project savedProject=projectService.saveProject(projectDTO);
		return ResponseEntity.status(201).body(savedProject);
	}
	 @GetMapping
	 public ResponseEntity<List<Project>> getAllProjects() {
	        return ResponseEntity.ok(projectService.getAllProjects());
	 }
	 
	
	 @GetMapping("/user/{userId}")
	 public List<Project> getProjectsByUserId(@PathVariable int userId)
	 {
		 return projectService.getProjectsByUserId(userId);
	 }
	 

}
