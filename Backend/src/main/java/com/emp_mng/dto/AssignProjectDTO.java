package com.emp_mng.dto;
public class AssignProjectDTO {
	
	 private int projectId;
	 private int userId;
	 
	 public AssignProjectDTO() {
		super();
	}
	public AssignProjectDTO(int projectId, int userId) {
		super();
		this.projectId = projectId;
		this.userId = userId;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	 
	 
	 
	 
}
	 