package com.emp_mng.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="skills")
public class Skill {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int skillId;
	
	private String skillName;
	
    private int userId;
    
    public Skill() {
		super();
		// TODO Auto-generated constructor stub
	}
	
  public Skill(int skillId, String skillName, int userId) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
		this.userId = userId;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
    
    
    
}
