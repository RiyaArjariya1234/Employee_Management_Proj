package com.emp_mng.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.emp2.dto.SkillDTO;
import com.emp_mng.entities.RoleType;
import com.emp_mng.entities.Skill;
import com.emp_mng.entities.User;
import com.emp_mng.exceptions.InvalidUserRoleException;
import com.emp_mng.repository.SkillRepository;
import com.emp_mng.repository.UserRepository;
import com.emp_mng.dto.UserDetailsDTO;
import java.util.*;


@Service
public class SkillService {

	@Autowired
    private SkillRepository skillRepository;
	@Autowired
    private UserRepository userRepository;

	 @Transactional
	public Skill saveSkill(Skill skill) {
        User user = userRepository.findById(skill.getUser().getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (user.getUserRoles().stream().noneMatch(role -> role.getRoleType() == RoleType.EMPLOYEE)) {
            throw new InvalidUserRoleException("Only employees can have skills");
        }

        skill.setUser(user);
        return skillRepository.save(skill);
    }
	 @Transactional
	 public List<UserDetailsDTO> getUsersBySkillName(String skillName) {
	        return skillRepository.findUsersBySkillName(skillName);
	    }
  
	



}

