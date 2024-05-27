package com.emp_mng.entities;
import javax.persistence.*;

@Entity
@Table(name = "role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userRoleId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRole(Integer userRoleId, User user, RoleType roleType) {
		super();
		this.userRoleId = userRoleId;
		this.user = user;
		this.roleType = roleType;
	}

	public Integer getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public RoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}
    
    

    
}


