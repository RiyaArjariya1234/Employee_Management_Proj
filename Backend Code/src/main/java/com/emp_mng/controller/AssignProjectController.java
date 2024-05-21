package com.emp_mng.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emp_mng.dto.AssignProjectDTO;
//import com.emp_mng.entities.AssignProject;
import com.emp_mng.service.AssignProjectService;

    @RestController
	@CrossOrigin
	@RequestMapping("/api/assignments")
	public class AssignProjectController {

	    @Autowired
	    private AssignProjectService assignmentService;

	    
	  /*  public ResponseEntity<AssignProject> assignProjectToManager(@RequestBody AssignProjectDTO assignProjectDTO) {
	        AssignProject assignment = assignmentService.assignProjectToManager(assignProjectDTO.getProjectId(), assignProjectDTO.getManagerId());
	        return ResponseEntity.status(201).body(assignment);
	    }*/
	    @PostMapping("/addassignments")
	    public ResponseEntity<String> assignProjectToManager(@RequestParam int projectId, @RequestParam int managerId) {
	    	 assignmentService.assignProjectToManager(projectId, managerId);
	        return ResponseEntity.ok("Project assigned to manager successfully");
	
	    }

	    @GetMapping("/data")
	    public ResponseEntity<List<AssignProjectDTO>> getAllAssignments() {
	        return ResponseEntity.ok(assignmentService.getAllAssignments());
	    }
	   

}
