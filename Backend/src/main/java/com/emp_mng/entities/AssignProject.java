package com.emp_mng.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AssignProject {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    @OneToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "projectId", nullable = false, unique = true)
	    private Project project;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "userId", nullable = false)
	    private User user;
	    
	    public AssignProject() {
			super();
		}
        public AssignProject(int id, Project project, User user) {
			super();
			this.id = id;
			this.project = project;
			this.user = user;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public Project getProject() {
			return project;
		}
		public void setProject(Project project) {
			this.project = project;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
        
}
