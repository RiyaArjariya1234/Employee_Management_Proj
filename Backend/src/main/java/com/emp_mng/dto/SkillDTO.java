package com.emp_mng.dto;

public class SkillDTO {
	
	 private String skillName;
	 private int userId;
	 
	 
	public SkillDTO() {
		super();
	}
	public SkillDTO(String skillName, int userId) {
	
		this.skillName = skillName;
		this.userId = userId;
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
