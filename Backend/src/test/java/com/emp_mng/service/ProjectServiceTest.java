package com.emp_mng.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.emp_mng.dto.ProjectDTO;

import com.emp_mng.repository.ProjectRepository;
//import com.emp_mng.service.ProjectService;
import com.emp_mng.entities.Project;

public class ProjectServiceTest {

    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private ProjectService projectService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveProject() {
       
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setName("New Project");
        projectDTO.setDescription("Project Description");

        Project savedProject = new Project();
        savedProject.setProjectId(1);  // Assuming Project entity has an ID field
        savedProject.setName("New Project");
        savedProject.setDescription("Project Description");

        when(projectRepository.save(any(Project.class))).thenReturn(savedProject);

      
        com.emp_mng.entities.Project result = projectService.saveProject(projectDTO);

      
        assertThat(result).isNotNull();
        assertThat(result.getProjectId()).isEqualTo(1);
        assertThat(result.getName()).isEqualTo("New Project");
        assertThat(result.getDescription()).isEqualTo("Project Description");
    }

    @Test
    public void testGetAllProjects() {
        // Arrange
        Project project1 = new Project();
        project1.setProjectId(1);
        project1.setName("Project 1");
        project1.setDescription("Description 1");

        Project project2 = new Project();
        project2.setProjectId(2);
        project2.setName("Project 2");
        project2.setDescription("Description 2");

        List<Project> expectedProjects = Arrays.asList(project1, project2);

        when(projectRepository.findAll()).thenReturn(expectedProjects);

      
        List<Project> result = projectService.getAllProjects();

        
        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).isEqualTo(expectedProjects);
    }
}

