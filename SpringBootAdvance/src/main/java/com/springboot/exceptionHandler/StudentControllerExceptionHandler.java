package com.springboot.exceptionHandler;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.springboot.exception.GenericExceptionResponse;
import com.springboot.exception.InvalidHeaderFieldException;
import com.springboot.exception.InvalidStudentException;

@RestControllerAdvice
public class StudentControllerExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(InvalidStudentException.class)
	public ResponseEntity<GenericExceptionResponse> handleInvalidStudentException(InvalidStudentException ise, WebRequest request) {
		GenericExceptionResponse exceptionRes= new GenericExceptionResponse(new Date(), ise.getMessage(), request.getDescription(false));
		return new ResponseEntity<GenericExceptionResponse>(exceptionRes,HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler(InvalidHeaderFieldException.class)
	public ResponseEntity<GenericExceptionResponse> handleMissingRequestHeader(InvalidHeaderFieldException ife, WebRequest request){
		GenericExceptionResponse exceptionRes= new GenericExceptionResponse(new Date(), ife.getMessage(), request.getDescription(true));
		return new ResponseEntity<GenericExceptionResponse>(exceptionRes,HttpStatus.PRECONDITION_FAILED);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		GenericExceptionResponse exceptionRes= new GenericExceptionResponse(new Date(), "Validation Error", request.getDescription(false));
		exceptionRes.addValidationErrors(ex.getBindingResult().getFieldErrors());
		return new ResponseEntity<Object>(exceptionRes,HttpStatus.BAD_REQUEST);
	}
}
