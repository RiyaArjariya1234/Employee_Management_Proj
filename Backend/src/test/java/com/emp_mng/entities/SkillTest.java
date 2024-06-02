package com.emp_mng.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

//import com.emp_mng.entities.Skill;
//import com.emp_mng.entities.User;

public class SkillTest {

    @Test
    public void testSkillEntityCreation() {
        User user = new User();
        user.setUserId(1);

   
        Skill skill = new Skill();
        skill.setSkillId(1);
        skill.setSkillName("Java");
        skill.setUser(user);

      
        assertEquals(1, skill.getSkillId());
        assertEquals("Java", skill.getSkillName());
        assertEquals(user, skill.getUser());
    }

    @Test
    public void testSkillEntityDefaultConstructor() {
        
        Skill skill = new Skill();

       
        assertEquals(0, skill.getSkillId());
        assertNull(skill.getSkillName());
        assertNull(skill.getUser());
    }

    @Test
    public void testSkillEntitySetterMethods() {
       
        Skill skill = new Skill();

       
        skill.setSkillId(1);
        skill.setSkillName("Python");

      
        assertEquals(1, skill.getSkillId());
        assertEquals("Python", skill.getSkillName());
    }
}

