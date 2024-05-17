package com.emp_mng.dto;

import com.emp_mng.entities.RoleType;

public class LoginDTO {
	
	private String email;
	
	private String password;
	private RoleType roleType;
	public LoginDTO() {
		super();
	}
	public LoginDTO(String email, String password,RoleType roleType) {
		this.email = email;
		this.password = password;
		this.roleType=roleType;
	}
   public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public RoleType getRoleType() {
		return roleType;
	}
	public void setRolerType(RoleType roleType) {
		this.roleType = roleType;
	}
	@Override
	public String toString() {
		return "LoginDTO [email=" + email + ", password=" + password + ", userType=" + roleType + "]";
	}
	
	
	

}
