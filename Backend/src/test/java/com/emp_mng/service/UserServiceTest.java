package com.emp_mng.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.eq;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.emp_mng.dto.LoginDTO;
import com.emp_mng.entities.RoleType;
import com.emp_mng.entities.User;
import com.emp_mng.repository.RoleRepository;
import com.emp_mng.repository.UserRepository;
import static org.mockito.ArgumentMatchers.anyString;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	    @Mock
	    private UserRepository userRepository;

	    @Mock
	    private RoleRepository roleRepository;

	    @Mock
	    private PasswordEncoder passwordEncoder;

	    @InjectMocks
	    private UserService userService;

	    @BeforeEach
	    public void setUp() {
	        MockitoAnnotations.openMocks(this);
	    }

	    @Test
	    public void testFindByEmail() {
	       
	        String email = "test@example.com";
	        User user = new User();
	        user.setEmail(email);
	        when(userRepository.findByEmail(email)).thenReturn(user);

	      
	        User foundUser = userService.findByEmail(email);

	     
	        assertThat(foundUser).isNotNull();
	        assertThat(foundUser.getEmail()).isEqualTo(email);
	    }
	    
	    @Test
	    public void testLoginUser_Success_WithRoleType() {
	        // Arrange
	        LoginDTO loginDTO = new LoginDTO();
	        loginDTO.setEmail("testuser@example.com");
	        loginDTO.setPassword("password");
	        loginDTO.setRolerType(RoleType.MANAGER);

	        User user = new User();
	        user.setUserId(1);
	        user.setEmail("testuser@example.com");
	        user.setPassword("encodedPassword");
	        
	      //  when(userRepository.findByEmail(anyString())).thenReturn(user);
	       // when(passwordEncoder.matches(anyString(), anyString())).thenReturn(true);

	       // when(userRepository.findByEmailAndUserRolesRoleType(anyString(), any(RoleType.))).thenReturn(user);
	       // when(passwordEncoder.matches(anyString(), anyString())).thenReturn(true);
	        when(userRepository.findByEmailAndUserRolesRoleType(anyString(), eq(RoleType.MANAGER))).thenReturn(user);
	        when(passwordEncoder.matches(anyString(), anyString())).thenReturn(true);
	        
	        
	        // Act
	        ResponseEntity<Map<String, String>> response = userService.loginUser(loginDTO);

	        // Assert
	        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	        assertThat(response.getBody()).isNotNull();
	        assertThat(response.getBody().get("userId")).isEqualTo("1");
	        assertThat(response.getBody().get("email")).isEqualTo("testuser@example.com");
	    }
	    @Test
	    public void testLoginUser_Failure_UserNotFound() {
	        // Arrange
	        LoginDTO loginDTO = new LoginDTO();
	        loginDTO.setEmail("testuser@example.com");
	        loginDTO.setPassword("password");

	        when(userRepository.findByEmail(anyString())).thenReturn(null);

	        // Act
	        ResponseEntity<Map<String, String>> response = userService.loginUser(loginDTO);

	        // Assert
	        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
	        assertThat(response.getBody()).isNull();
	    }

	    @Test
	    public void testLoginUser_Failure_InvalidPassword() {
	        // Arrange
	        LoginDTO loginDTO = new LoginDTO();
	        loginDTO.setEmail("testuser@example.com");
	        loginDTO.setPassword("wrongPassword");

	        User user = new User();
	        user.setUserId(1);
	        user.setEmail("testuser@example.com");
	        user.setPassword("encodedPassword");

	        when(userRepository.findByEmail(anyString())).thenReturn(user);
	        when(passwordEncoder.matches(anyString(), anyString())).thenReturn(false);

	        // Act
	        ResponseEntity<Map<String, String>> response = userService.loginUser(loginDTO);

	        // Assert
	        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
	        assertThat(response.getBody()).isNull();
	    }

	   

}
