package com.emp_mng.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.emp_mng.dto.ManagerDTO;
//import com.emp_mng.entities.Manager;
//import com.emp_mng.repository.ManagerRepository;
import com.emp_mng.service.ManagerService;

@RestController
@CrossOrigin
@RequestMapping("/api/managers")
public class ManagerController {
	
	@Autowired
	private ManagerService managerService;
	
	@GetMapping("/{id}")
	public ManagerDTO getManagerById(@PathVariable int id)
	{
		 return managerService.getManagerById(id);
	}
	
	 @GetMapping
	    public List<ManagerDTO> getAllManagers() {
	        return managerService.getAllManagers();
	    }
	 
	
    
}
