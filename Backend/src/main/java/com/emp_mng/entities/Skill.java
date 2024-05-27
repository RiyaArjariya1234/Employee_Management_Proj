package com.emp_mng.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="skills")
public class Skill {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int skillId;
	
	private String skillName;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
	 private User user;

	 public Skill() {
		super();
		
	}

	public Skill(int skillId, String skillName, User user) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
		this.user = user;
	}

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	    
    
    
    
    
    
}
