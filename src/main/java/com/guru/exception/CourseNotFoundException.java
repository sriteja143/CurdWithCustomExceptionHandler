package com.guru.exception;

public class CourseNotFoundException extends RuntimeException{

	public CourseNotFoundException(String cause) {
		super(cause);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CourseNotFoundException() {
		super();
	}
}
