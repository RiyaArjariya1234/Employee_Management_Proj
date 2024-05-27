package com.emp_mng.exceptions;

public class ProjectAlreadyAssignedException extends RuntimeException {
	private static final long serialVersionUID = 1L;
    public ProjectAlreadyAssignedException(String message) {
        super(message);
    }
}
