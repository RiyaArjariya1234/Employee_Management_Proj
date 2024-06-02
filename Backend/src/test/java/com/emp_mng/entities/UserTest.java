package com.emp_mng.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserTest {

    @Test
    public void testUserEntityCreation() {
       
        Set<UserRole> userRoles = new HashSet<>();
        UserRole userRole = new UserRole();
        userRole.setRoleType(RoleType.EMPLOYEE); 
        userRoles.add(userRole);

      
        User user = new User();
        user.setUserId(1);
        user.setName("John Doe");
        user.setEmail("john@example.com");
        user.setMobileNo("1234567890");
        user.setPassword("password");
        user.setUserRoles(userRoles);

        
        assertEquals(1, user.getUserId());
        assertEquals("John Doe", user.getName());
        assertEquals("john@example.com", user.getEmail());
        assertEquals("1234567890", user.getMobileNo());
        assertEquals("password", user.getPassword());
        assertNotNull(user.getUserRoles());
        assertEquals(1, user.getUserRoles().size());
    }

    @Test
    public void testUserEntityDefaultConstructor() {
       
        User user = new User();
        assertNull(user.getUserId());
        assertNull(user.getName());
        assertNull(user.getEmail());
        assertNull(user.getMobileNo());
        assertNull(user.getPassword());
        assertNull(user.getUserRoles());
    }
}

