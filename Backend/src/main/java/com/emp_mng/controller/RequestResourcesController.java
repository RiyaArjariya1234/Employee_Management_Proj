package com.emp_mng.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.emp_mng.service.RequestResourceService;
import com.emp_mng.dto.RequestResourcesDTO;
import com.emp_mng.entities.RequestResources;




@RestController
@CrossOrigin
@RequestMapping("/api/request")
public class RequestResourcesController {
	
	@Autowired
	private RequestResourceService requestResourcesService; 
	
	@PostMapping("/addRequest")
	public ResponseEntity<RequestResources> addRequest(@RequestBody RequestResourcesDTO requestResourcesDTO)
	{
		RequestResources saveResources=requestResourcesService.createRequest(requestResourcesDTO);
		return ResponseEntity.status(201).body(saveResources);
	}

}
