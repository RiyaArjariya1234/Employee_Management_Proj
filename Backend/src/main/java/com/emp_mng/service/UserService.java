package com.emp_mng.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import java.util.Collections;
//import java.util.HashSet;
//import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.emp_mng.dto.LoginDTO;
import com.emp_mng.dto.UserDTO;
import com.emp_mng.entities.RoleType;
import com.emp_mng.entities.User;
import com.emp_mng.entities.UserRole;
import com.emp_mng.repository.RoleRepository;
import com.emp_mng.repository.UserRepository;



@Service
public class UserService
{
	@Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
   
    @Transactional
    public User saveUserWithRole(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setMobileNo(userDTO.getPhoneNo());
        user.setPassword(userDTO.getPassword());
        
       
       
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        User savedUser = userRepository.save(user);

        UserRole role = new UserRole();
        role.setUser(savedUser);
        role.setRoleType(userDTO.getRoleType());
        //savedUser.setUserRoles(role);
        roleRepository.save(role);

        if (userDTO.getRoleType() == RoleType.MANAGER) {
            UserRole employeeRole = new UserRole();
            employeeRole.setUser(savedUser);
            employeeRole.setRoleType(RoleType.EMPLOYEE);
            roleRepository.save(employeeRole);
        }
       /* switch (userDTO.getRoleType()) {
        case ADMIN:
            Admin admin = new Admin();
            admin.setUser(user);
            adminRepo.save(admin);
            break;
        case MANAGER:
            Manager manager = new Manager();
            manager.setUser(user);
            managerRepo.save(manager);
            Employee employe = new Employee();
            employe.setUser(user);
            employeeRepo.save(employe);
            break;
        case EMPLOYEE:
            Employee employee = new Employee();
            employee.setUser(user);
            employeeRepo.save(employee);
            break;
        }*/
        return savedUser;
    }
    @Transactional
    public ResponseEntity<Map<String,String>> loginUser(LoginDTO  loginDTO) {
    	//User user = userRepository.findByEmail(loginDTO.getEmail());
    	 User user;
    	 if (loginDTO.getRoleType() != null) {
             
             user = userRepository.findByEmailAndUserRolesRoleType(loginDTO.getEmail(), loginDTO.getRoleType());
         } else {
             
             user = userRepository.findByEmail(loginDTO.getEmail());
         }
         
         if (user != null && passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {

        	 Map<String, String> response = new HashMap<>();
             response.put("userId", String.valueOf(user.getUserId()));
             response.put("email", user.getEmail());
             //response.put("roleType", user.getRoleType());
             return new ResponseEntity<>(response, HttpStatus.OK);
         }
        else {
                 return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
         }
        
           
           
    } 
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public User updateUser(int id, User userDetails) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        user.setMobileNo(userDetails.getMobileNo());

        return userRepository.save(user);
    }
    public void deleteUser(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
    }
}
