package com.emp_mng.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProjectNotFoundException.class)
    public ResponseEntity<String> handleProjectNotFoundException(ProjectNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProjectAlreadyAssignedException.class)
    public ResponseEntity<String> handleProjectAlreadyAssignedException(ProjectAlreadyAssignedException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UserNotManagerException.class)
    public ResponseEntity<String> handleUserNotManagerException(UserNotManagerException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidUserRoleException.class)
    public ResponseEntity<String> handleInvalidUserRoleException(InvalidUserRoleException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
   
     @ExceptionHandler(AlreadyAssignedException.class)
	    public ResponseEntity<String> handleAlreadyAssignedException(AlreadyAssignedException ex) {
	      //  return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
	    	 return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	    }

	  @ExceptionHandler(PendingRequestException.class)
	   public ResponseEntity<String> handlePendingRequestException(PendingRequestException ex) {
	        //return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
	    	return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
	    } 
	  // Add a generic exception handler if needed
	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<String> handleGenericException(Exception ex) {
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        
    }
}





