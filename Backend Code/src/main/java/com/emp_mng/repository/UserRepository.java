package com.emp_mng.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emp_mng.entities.RoleType;
import com.emp_mng.entities.User;
//import com.emp_mng.entities.UserType;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	
	 User findByEmail(String email);
	// User findByEmailAndRoleType(String email,RoleType roleType);
	 User findByEmailAndUserRolesRoleType(String email, RoleType roleType);
	//Optional<User> findOneByEmailAndPassword(String email,String password);
   // User findByEmailAndUserType(String email,UserType userType);
	
}


