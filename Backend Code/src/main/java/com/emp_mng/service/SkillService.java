package com.emp_mng.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp_mng.dto.SkillDTO;
import com.emp_mng.entities.Skill;
import com.emp_mng.repository.SkillRepository;

@Service
public class SkillService {

	@Autowired
    private SkillRepository skillRepository;
	
	@Transactional
	public Skill saveSkill(SkillDTO skillDTO)
	{
		Skill skill=new Skill();
		skill.setSkillName(skillDTO.getSkillName());
		skill.setUserId(skillDTO.getUserId());
		return skillRepository.save(skill);
	}


}
