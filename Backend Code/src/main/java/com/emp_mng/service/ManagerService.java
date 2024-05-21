package com.emp_mng.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp_mng.dto.ManagerDTO;
import com.emp_mng.entities.Manager;
import com.emp_mng.entities.User;
import com.emp_mng.repository.ManagerRepository;

@Service
public class ManagerService {
	
	    @Autowired
	    private ManagerRepository managerRepository;

	    public ManagerDTO getManagerById(int managerId) {
	        Optional<Manager> managerOptional = managerRepository.findById(managerId);
	        if (managerOptional.isPresent()) {
	            Manager manager = managerOptional.get();
	            User user = manager.getUser();
	            return new ManagerDTO(manager.getManagerId(), user.getName());
	        } else {
	            throw new RuntimeException("Manager not found with id: " + managerId);
	        	// throw new ManagerNotFoundException("Manager not found with id: " + managerId);
	        }
	    }

	    public List<ManagerDTO> getAllManagers() {
	        List<Manager> managers = managerRepository.findAll();
	        return managers.stream()
	                       .map(manager -> new ManagerDTO(manager.getManagerId(), manager.getUser().getName()))
	                       .collect(Collectors.toList());
	    }

}
