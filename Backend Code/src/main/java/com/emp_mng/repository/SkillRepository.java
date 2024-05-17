package com.emp_mng.repository;

import org.springframework.data.jpa.repository.JpaRepository;

//import com.emp_mng.entities.Admin;
import com.emp_mng.entities.Skill;

public interface SkillRepository extends JpaRepository<Skill,Integer> {
	

}
