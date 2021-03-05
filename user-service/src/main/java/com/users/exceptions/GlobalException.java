package com.users.exceptions;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;




@RestControllerAdvice
public class GlobalException {
	private static final Logger logger = LoggerFactory.getLogger(GlobalException.class);
	
	
	@ExceptionHandler(value = { UserNotFoundException.class })
    public ResponseEntity<Object> handleInvalidInputException(UserNotFoundException ex, WebRequest request) {
		logger.error("Invalid Input Exception: ",ex.getMessage());
         return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }
	
	
	
	
	

}
