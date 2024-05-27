/*package com.emp_mng.repository;

import org.springframework.data.jpa.repository.JpaRepository;

//import com.emp_mng.entities.Admin;
import com.emp_mng.entities.Skill;

public interface SkillRepository extends JpaRepository<Skill,Integer> {
	

}*/
package com.emp_mng.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.emp_mng.entities.Skill;
import com.emp_mng.dto.UserDetailsDTO;
import java.util.*;


@Repository
public interface SkillRepository extends JpaRepository<Skill,Integer> {
	
	@Query("SELECT new com.emp_mng.dto.UserDetailsDTO(u.userId, u.name, u.email) " +
	           "FROM Skill s JOIN s.user u WHERE s.skillName = :skillName")
	    List<UserDetailsDTO> findUsersBySkillName(@Param("skillName") String skillName);

}
