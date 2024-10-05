package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvicer {
	
	@ExceptionHandler
	public ResponseEntity<String>exceptionhandler(CustomException e){
		return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		
	}

}
