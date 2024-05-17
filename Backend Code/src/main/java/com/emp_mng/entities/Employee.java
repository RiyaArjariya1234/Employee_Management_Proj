package com.emp_mng.entities;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Employee {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer EmpId;

	    @OneToOne(cascade = CascadeType.ALL)
	   // @MapsId
	   // @JoinColumn(name="Emp_id")
	    @JoinColumn(name="fk_user_id")
	    private User user;

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

	    // Getters and setters
	    
	}

