package com.emp_mng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.emp_mng.service.AssignProjectService;



@RestController
@CrossOrigin
@RequestMapping("/api/assignments")
public class AssignProjectController {
	

    @Autowired
    private AssignProjectService assignmentService;
    
   
	
	 @PostMapping("/addassignments")
	 public ResponseEntity<String> assignProjectToManager(@RequestParam int projectId, @RequestParam int managerId) {
	    	 assignmentService.assignProjectToManager(projectId, managerId);
	        return ResponseEntity.ok("Project assigned to manager successfully");
	
	  }
	 
	 

}
