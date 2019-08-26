package com.springboot.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.validation.FieldError;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class GenericExceptionResponse {
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date timeStamp;
	private String message;
	private String details;
	private Map<String,List<ApiValidationError>> subErrors;

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

	public Map<String,List<ApiValidationError>> getSubErrors() {
		return subErrors;
	}

	public void setSubErrors(Map<String,List<ApiValidationError>> subErrors) {
		this.subErrors = subErrors;
	}
	
	private void addValidationError(String object, String field, Object rejectedValue, String message) {
		ApiValidationError validationError = new ApiValidationError(object, field, rejectedValue, message);
		if (this.subErrors == null) {
			this.subErrors = new HashMap<String,List<ApiValidationError>>();
		}
		int endIndex = field.indexOf(".");
		String key = field.substring(0,endIndex);
		List<ApiValidationError> validationErrorList = this.subErrors.getOrDefault(key, new ArrayList<>());
		validationErrorList.add(validationError);
		this.subErrors.put(key,validationErrorList);
	}

	private void addValidationError(FieldError fieldError) {
		this.addValidationError(fieldError.getObjectName(), fieldError.getField(), fieldError.getRejectedValue(),
				fieldError.getDefaultMessage());
	}
	
	public void addValidationErrors(List<FieldError> fieldErrors) {
        fieldErrors.forEach(this::addValidationError);
    }
}
