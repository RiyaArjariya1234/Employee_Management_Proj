package com.emp_mng.entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "projects")
public class Project {
	
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Id
	 private int projectId;
	 private String name;
	 private String description;
	 
	 public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(int projectId, String name, String description) {
		super();
		this.projectId = projectId;
		this.name = name;
		this.description = description;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	 
	
	 


}
