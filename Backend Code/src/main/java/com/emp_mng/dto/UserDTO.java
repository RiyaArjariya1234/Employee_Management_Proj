package com.emp_mng.dto;

import com.emp_mng.entities.RoleType;

public class UserDTO {
    private String username;
    private String email;
    private String phoneNo;
    private String password;
    private RoleType roleType;
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDTO(String username, String email, String phoneNo, String password, RoleType roleType) {
		super();
		this.username = username;
		this.email = email;
		this.phoneNo = phoneNo;
		this.password = password;
		this.roleType = roleType;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
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
	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}
	

    // Getters and setters
}


/*import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.emp_mng.entities.RoleType;

public class UserDTO {
	
	private Integer userId;
	private String name;
    private String email;
    private String mobileNo;
    private String password;
    @Enumerated(EnumType.STRING)
    private RoleType userType;
    public UserDTO(Integer userId, String name, String email, String mobileNo, String password,RoleType userType) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.mobileNo = mobileNo;
		this.password = password;
		this.userType= userType;
	}
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public RoleType getUserType() {
		return userType;
	}
	public void setUserType(RoleType userType) {
		this.userType = userType;
	}
	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", name=" + name + ", email=" + email + ", mobileNo=" + mobileNo
				+ ", password=" + password + ", userType=" + userType + "]";
	}
	
	
    
    
}*/
