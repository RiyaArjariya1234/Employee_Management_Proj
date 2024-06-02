package com.emp_mng.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp_mng.entities.AssignProject;
import com.emp_mng.entities.Project;
import com.emp_mng.entities.RoleType;
import com.emp_mng.entities.User;
import com.emp_mng.exceptions.ProjectAlreadyAssignedException;
import com.emp_mng.exceptions.UserNotFoundException;
import com.emp_mng.exceptions.UserNotManagerException;
import com.emp_mng.repository.AssignProjectRepository;
import com.emp_mng.repository.ProjectRepository;
import com.emp_mng.repository.UserRepository;
import java.util.List;

@Service
public class AssignProjectService {

    @Autowired
    private AssignProjectRepository assignProjectRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;
    
    
   
   /* public AssignProjectService(AssignProjectRepository assignProjectRepository) {
        this.assignProjectRepository = assignProjectRepository;
    }*/

    @Transactional
    public AssignProject assignProjectToManager(Integer projectId, Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        
        if (!user.getUserRoles().stream().anyMatch(role -> role.getRoleType() == RoleType.MANAGER)) {
            throw new UserNotManagerException("User is not a manager");
        }

        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));
        if (assignProjectRepository.existsByProject(project)) {
            throw new ProjectAlreadyAssignedException("Project already assigned to a manager");
        }

        AssignProject assignedProject=new AssignProject();
        assignedProject.setProject(project);
        assignedProject.setUser(user);
        
        return assignProjectRepository.save(assignedProject);
    }
    @Transactional
    public List<AssignProject> getAllAssignments()
    {
	
	   return assignProjectRepository.findAll();
    }
   
}
