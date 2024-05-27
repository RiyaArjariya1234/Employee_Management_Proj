package com.emp_mng.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emp_mng.dto.SkillDTO;
import com.emp_mng.entities.Skill;
import com.emp_mng.entities.User;
import com.emp_mng.service.SkillService;
import com.emp_mng.dto.UserDetailsDTO;


@RestController
@CrossOrigin
@RequestMapping("/api/skill")
public class SkillController {
	
	@Autowired
	private SkillService skillService;
	
	@PostMapping("/addSkill")
	public Skill addSkill(@RequestBody SkillDTO skillDTO) {
        Skill skill = new Skill();
        skill.setSkillName(skillDTO.getSkillName());
        User user = new User();
        user.setUserId(skillDTO.getUserId());
        skill.setUser(user);
        return skillService.saveSkill(skill);
    }
	
	@GetMapping("/filter")
    public List<UserDetailsDTO> getUsersBySkillName(@RequestParam String skillName) {
        return skillService.getUsersBySkillName(skillName);
    }
	

}
