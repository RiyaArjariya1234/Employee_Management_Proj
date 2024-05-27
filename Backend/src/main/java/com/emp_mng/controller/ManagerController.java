package com.emp_mng.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp_mng.dto.ManagerDTO;
import com.emp_mng.service.ManagerService;

@RestController
@RequestMapping("/api/managers")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @GetMapping
    public List<ManagerDTO> getAllManagers() {
        return managerService.findAllManagers();
    }
}
