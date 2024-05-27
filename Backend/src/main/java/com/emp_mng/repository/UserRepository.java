package com.emp_mng.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.emp_mng.dto.ManagerDTO;
import com.emp_mng.entities.RoleType;
import com.emp_mng.entities.User;


@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	
	 User findByEmail(String email);
	 User findByEmailAndUserRolesRoleType(String email, RoleType roleType);
	 @Query("SELECT new com.emp_mng.dto.ManagerDTO(u.userId, u.name) FROM User u JOIN u.userRoles r WHERE r.roleType = :roleType")
	    List<ManagerDTO> findManagersByRoleType(@Param("roleType") RoleType roleType);
	
	
}



