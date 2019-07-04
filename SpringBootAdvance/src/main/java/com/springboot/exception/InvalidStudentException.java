package com.springboot.exception;

public class InvalidStudentException extends RuntimeException {

	private String message;
	
	public InvalidStudentException(String message) {
		super(message);
	}
}
