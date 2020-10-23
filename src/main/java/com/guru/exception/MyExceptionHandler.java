package com.guru.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {
	
	@ExceptionHandler(CourseNotFoundException.class)
	public ResponseEntity<ErrorType> handleNotFound(CourseNotFoundException ex) {
		ErrorType errtype = new ErrorType(ex.getMessage(), "500", "COURSE_NOT_FOUND", "Course");
		return new ResponseEntity<ErrorType>(errtype, HttpStatus.EXPECTATION_FAILED);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorType> handleException(Exception ex) {
		ErrorType errtype = new ErrorType(ex.getMessage(),"500", "TECHINACL_ERROR", "Course");
		return new ResponseEntity<ErrorType>(errtype, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
