package com.emp_mng.dto;

public class ManagerDTO {
	 private int managerId;
	 private String managerName;
	 
	 public ManagerDTO() {
		super();
	}
	public ManagerDTO(int managerId, String managerName) {
		this.managerId = managerId;
		this.managerName = managerName;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	 

}
