package com.emp_mng.dto;

public class RequestResourcesDTO {
	
	  private int managerId;
	    private int employeeId;
	    private int projectId;
		public RequestResourcesDTO() {
			super();
		
		}
		
		public RequestResourcesDTO(int managerId, int employeeId, int projectId) {
	
			this.managerId = managerId;
			this.employeeId = employeeId;
			this.projectId = projectId;
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
		
	    


}
