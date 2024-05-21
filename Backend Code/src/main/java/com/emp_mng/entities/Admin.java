package com.emp_mng.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Admin {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		 
	    private Integer AdminId;
        
	    @OneToOne(cascade = CascadeType.ALL)
	 //   @MapsId
	    @JoinColumn(name="fk_user_id")
	    private User user;

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

	    
	    
	}


