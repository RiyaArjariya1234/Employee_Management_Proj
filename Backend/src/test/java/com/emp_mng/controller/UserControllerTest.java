package com.emp_mng.controller;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
//import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.emp_mng.entities.RoleType;
import com.emp_mng.entities.User;
import com.emp_mng.entities.UserRole;
import com.emp_mng.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetAllUsers() throws Exception {
        // Arrange
        User user1 = new User();
        user1.setUserId(1);
        user1.setName("testuser1");
        user1.setEmail("testuser1@example.com");
        UserRole userRole1 = new UserRole();
        userRole1.setUser(user1);
        userRole1.setRoleType(RoleType.EMPLOYEE);
        user1.setUserRoles(new HashSet<>(Arrays.asList(userRole1)));

        User user2 = new User();
        user2.setUserId(2);
        user2.setName("testuser2");
        user2.setEmail("testuser2@example.com");
        UserRole userRole2 = new UserRole();
        userRole2.setUser(user2);
        userRole2.setRoleType(RoleType.MANAGER);
        user2.setUserRoles(new HashSet<>(Arrays.asList(userRole2)));

        List<User> users = Arrays.asList(user1, user2);

        when(userService.getAllUsers()).thenReturn(users);

        // Act & Assert
        mockMvc.perform(get("/api/users")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(users)));
    }
}
