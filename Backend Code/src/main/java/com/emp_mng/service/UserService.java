package com.emp_mng.service;

import java.util.HashMap;
import java.util.Map;

//import java.util.Collections;
//import java.util.HashSet;
//import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;

import com.emp_mng.dto.LoginDTO;
import com.emp_mng.dto.UserDTO;
import com.emp_mng.entities.Admin;
import com.emp_mng.entities.Employee;
import com.emp_mng.entities.Manager;
import com.emp_mng.entities.RoleType;
import com.emp_mng.entities.User;
import com.emp_mng.entities.UserRole;
import com.emp_mng.repository.AdminRepository;
import com.emp_mng.repository.EmployeeRepository;
import com.emp_mng.repository.ManagerRepository;
import com.emp_mng.repository.RoleRepository;
import com.emp_mng.repository.UserRepository;
import com.emp_mng.response.LoginMessage;

//import org.springframework.stereotype.Service;

//import com.emp_mng.dto.LoginDTO;
//import com.emp_mng.dto.UserDTO;
//import com.emp_mng.response.LoginMessage;

/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.emp_mng.entities.Admin;
import com.emp_mng.entities.Employee;
import com.emp_mng.entities.Manager;
import com.emp_mng.entities.User;
import com.emp_mng.entities.UserType;
import com.emp_mng.repository.AdminRepository;
import com.emp_mng.repository.EmployeeRepository;
import com.emp_mng.repository.ManagerRepository;
import com.emp_mng.repository.UserRepository;*/

@Service
public class UserService
{
	@Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private AdminRepository adminRepo;

    @Autowired
    private ManagerRepository managerRepo;

    @Autowired
    private EmployeeRepository employeeRepo;


    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
   
    @Transactional
    public User saveUserWithRole(UserDTO userDTO) {
        User user = new User();
        // Map fields from userDTO to user object
        user.setName(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setMobileNo(userDTO.getPhoneNo());
        user.setPassword(userDTO.getPassword());
        
       
       
        
        // Hash the password
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
        switch (userDTO.getRoleType()) {
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
        }
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
    /*public ResponseEntity<LoginMessage> loginUser(LoginDTO  loginDTO) {
        User user;
        
        if (loginDTO.getRoleType() != null) {
            
            user = userRepository.findByEmailAndUserRolesRoleType(loginDTO.getEmail(), loginDTO.getRoleType());
        } else {
            
            user = userRepository.findByEmail(loginDTO.getEmail());
        }
        
        if (user != null && passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
           
            return ResponseEntity.ok(new LoginMessage("Login successful"));
        } else {
          
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginMessage("Invalid email, password, or role type"));
        }
    }*/



   /* @Transactional
    public User saveUserWithRole(User user, RoleType roleType) {
        // Hash the password
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        User savedUser = userRepository.save(user);

        UserRole role = new UserRole();
        role.setUser(savedUser);
        role.setRoleType(roleType);
        roleRepository.save(role);
        if (roleType == RoleType.MANAGER) {
            UserRole employeeRole = new UserRole();
            employeeRole.setUser(savedUser);
            employeeRole.setRoleType(RoleType.EMPLOYEE);
            roleRepository.save(employeeRole);
        }


        return savedUser;*/
    }

/*public interface UserService
{
	String addUser(UserDTO  userDTO);
	LoginMessage loginUser(LoginDTO loginDTO);
}*/

/*@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }*/
   /* public User findByEmailAndUserType(String email, UserType userType) {
        return userRepository.findByEmailAndUserType(email, userType);
    }*/

   /* public User createUser(User user) {
        switch (user.getUserType()) {
            case ADMIN:
                Admin admin = new Admin();
                admin.setUser(user);
                adminRepository.save(admin);
                break;
            case MANAGER:
                Manager manager = new Manager();
                manager.setUser(user);
                managerRepository.save(manager);
                break;
            case EMPLOYEE:
                Employee employee = new Employee();
                employee.setUser(user);
                employeeRepository.save(employee);
                break;
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}*/

