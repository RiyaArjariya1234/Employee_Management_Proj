package com.emp_mng.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;



public class ProjectTest {

    @Test
    public void testProjectEntityCreation() {
     
        Project project = new Project();
        project.setProjectId(1);
        project.setName("Project A");
        project.setDescription("Description of Project A");

      
        assertEquals(1, project.getProjectId());
        assertEquals("Project A", project.getName());
        assertEquals("Description of Project A", project.getDescription());
    }

    @Test
    public void testProjectEntityDefaultConstructor() {
      
        Project project = new Project();
        assertEquals(0, project.getProjectId());
        assertNull(project.getName());
        assertNull(project.getDescription());
    }
}

