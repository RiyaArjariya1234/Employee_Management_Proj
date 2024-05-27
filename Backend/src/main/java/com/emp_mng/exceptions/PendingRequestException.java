package com.emp_mng.exceptions;

public class PendingRequestException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public PendingRequestException(String message)  {
        super(message);
    }

}
