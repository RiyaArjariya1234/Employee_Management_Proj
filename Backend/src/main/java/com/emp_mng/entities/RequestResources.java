package com.emp_mng.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RequestResources {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int requestId;
    private int managerId;
    private int employeeId;
    private int projectId;
    private String status = "Pending";
    
	public RequestResources() {
		super();
	
	}
  public RequestResources(int requestId, int managerId, int employeeId, int projectId, String status) {
		super();
		this.requestId = requestId;
		this.managerId = managerId;
		this.employeeId = employeeId;
		this.projectId = projectId;
		this.status = status;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	

    

}

