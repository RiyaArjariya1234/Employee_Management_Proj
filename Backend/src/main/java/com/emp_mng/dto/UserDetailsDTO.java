package com.emp_mng.dto;

public class UserDetailsDTO {

	private Integer userId;
    private String name;
    private String email;

    public UserDetailsDTO() {
    }

    public UserDetailsDTO(Integer userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
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
	
	
	
}
