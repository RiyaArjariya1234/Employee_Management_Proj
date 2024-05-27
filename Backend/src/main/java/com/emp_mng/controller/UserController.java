package com.emp_mng.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emp_mng.dto.LoginDTO;
import com.emp_mng.dto.UserDTO;
import com.emp_mng.service.UserService;



@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class UserController {

	@Autowired
    private UserService userService;
	
	@PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDTO  userDTO) {
	 if (userService.findByEmail(userDTO.getEmail()) != null) {
         return new ResponseEntity<>("User with this email already exists", HttpStatus.BAD_REQUEST);
     }
	 userService.saveUserWithRole(userDTO);
     return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
	}
	
    @PostMapping("/login")
	    public ResponseEntity<Map<String, String>> loginUser(@RequestBody LoginDTO loginDTO) {
	        return userService.loginUser(loginDTO);
	    }
     
  
	

	 

      
     
}
