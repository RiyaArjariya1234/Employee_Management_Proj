package com.emp_mng.dto;

public class AssignProjectDTO {
	
	 private int projectId;
	 private int managerId;
	 
	public AssignProjectDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AssignProjectDTO(int projectId, int managerId) {
		this.projectId = projectId;
		this.managerId = managerId;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	  

}
