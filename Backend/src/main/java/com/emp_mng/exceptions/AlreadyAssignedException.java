package com.emp_mng.exceptions;

public class AlreadyAssignedException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public AlreadyAssignedException(String message) {
        super(message);
    }

}
