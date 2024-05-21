package com.emp_mng.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import com.emp_mng.entities.Assignment;
import com.emp_mng.entities.Project;
import com.emp_mng.dto.AssignProjectDTO;
import com.emp_mng.entities.AssignProject;
import com.emp_mng.entities.Manager;
//import com.emp_mng.repository.AssignmentRepository;
import com.emp_mng.repository.AssignProjectRepository;
import com.emp_mng.repository.ProjectRepository;
import com.emp_mng.repository.ManagerRepository;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

@Service
public class AssignProjectService {

    @Autowired
    private AssignProjectRepository assignProjectRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ManagerRepository managerRepository;

    @Transactional
    public void assignProjectToManager(int projectId, int managerId) {
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new RuntimeException("Project not found"));
        Manager manager = managerRepository.findById(managerId).orElseThrow(() -> new RuntimeException("Manager not found"));
       
        if (assignProjectRepository.existsByProject(project)) {
            throw new RuntimeException("Project already assigned to a manager");
        }
        AssignProject assignment = new AssignProject();
        assignment.setProject(project);
        assignment.setManager(manager);
        assignProjectRepository.save(assignment);
    }

    public List<AssignProjectDTO> getAllAssignments() {
        return assignProjectRepository.findAll().stream()
                .map(assignment -> new AssignProjectDTO(
                        assignment.getProject().getProjectId(),
                        assignment.getManager().getManagerId()))
                .collect(Collectors.toList());
    }
   /* public List<AssignProject> getAllAssignProject() {
        return assignProjectRepository.findAll();
    }*/
}

