package com.springboot.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.validation.FieldError;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class GenericExceptionResponse {
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date timeStamp;
	private String message;
	private String details;
	private List<ApiValidationError> subErrors;

	public GenericExceptionResponse(Date timeStamp, String message, String details) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public List<ApiValidationError> getSubErrors() {
		return subErrors;
	}

	public void setSubErrors(List<ApiValidationError> subErrors) {
		this.subErrors = subErrors;
	}
	
	private void addValidationError(String object, String field, Object rejectedValue, String message) {
		ApiValidationError validationError = new ApiValidationError(object, field, rejectedValue, message);
		if (this.subErrors == null) {
			this.subErrors = new ArrayList<>();
		}
		this.subErrors.add(validationError);
	}

	private void addValidationError(FieldError fieldError) {
		this.addValidationError(fieldError.getObjectName(), fieldError.getField(), fieldError.getRejectedValue(),
				fieldError.getDefaultMessage());
	}
	
	public void addValidationErrors(List<FieldError> fieldErrors) {
        fieldErrors.forEach(this::addValidationError);
    }
}
