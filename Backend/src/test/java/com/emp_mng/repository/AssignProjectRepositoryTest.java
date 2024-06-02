package com.emp_mng.repository;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.emp_mng.entities.AssignProject;
import com.emp_mng.entities.Project;

@SpringBootTest
public class AssignProjectRepositoryTest {

    @MockBean
    private AssignProjectRepository assignProjectRepository;

    @Test
    public void testExistsByProject() {
     
        Project project = new Project();
        project.setProjectId(1);
        
      
        when(assignProjectRepository.existsByProject(project)).thenReturn(true);

     
        boolean exists = assignProjectRepository.existsByProject(project);

     
        assertThat(exists).isTrue();
    }
     @Test
    public void testFindByUser_UserId() {
        
        int userId = 123;
        List<AssignProject> projects = Arrays.asList(new AssignProject(), new AssignProject());
        
      
        when(assignProjectRepository.findByUser_UserId(userId)).thenReturn(projects);

       
        List<AssignProject> foundProjects = assignProjectRepository.findByUser_UserId(userId);

      
        assertThat(foundProjects).isNotNull();
        assertThat(foundProjects.size()).isEqualTo(2);
    }
    
    
    
    
    
    
    
}
