package com.emp_mng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp_mng.dto.SkillDTO;
import com.emp_mng.entities.Skill;
import com.emp_mng.service.SkillService;

@RestController
@CrossOrigin
@RequestMapping("/api/skill")
public class SkillController {
	
	@Autowired
	private SkillService skillService;
	
	@PostMapping("/addSkill")
	public ResponseEntity<Skill> addSkill(@RequestBody SkillDTO skillDTO)
	{
		Skill savedSkill=skillService.saveSkill(skillDTO);
		return ResponseEntity.status(201).body(savedSkill);
	}

}
