package com.emp_mng.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import javax.persistence.Table;

@Entity
public class AssignProject {
	
	
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    @OneToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "projectId", nullable = false, unique = true)
	    private Project project;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "managerId", nullable = false)
	    private Manager manager;

		public AssignProject() {
			super();
			// TODO Auto-generated constructor stub
		}

		public AssignProject(int id, Project project, Manager manager) {
			super();
			this.id = id;
			this.project = project;
			this.manager = manager;
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

		public Manager getManager() {
			return manager;
		}

		public void setManager(Manager manager) {
			this.manager = manager;
		}
	    
	    

	
	
	
	
	
	   
}
