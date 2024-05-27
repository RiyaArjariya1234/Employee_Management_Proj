package com.emp_mng.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp_mng.dto.ManagerDTO;
import com.emp_mng.entities.RoleType;
import com.emp_mng.repository.UserRepository;

@Service
public class ManagerService {

    @Autowired
    private UserRepository userRepository;

    public List<ManagerDTO> findAllManagers() {
        return userRepository.findManagersByRoleType(RoleType.MANAGER);
    }
}
