package com.emp_mng.exceptions;


public class UserNotManagerException extends RuntimeException {
	 private static final long serialVersionUID = 1L;
    public UserNotManagerException(String message) {
        super(message);
    }
}

