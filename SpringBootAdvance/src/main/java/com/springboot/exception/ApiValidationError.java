package com.springboot.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.FieldError;



class ApiSubError {

}

public class ApiValidationError extends ApiSubError {
	private String object;
	private String field;
	private Object rejectedValue;
	private String message;

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Object getRejectedValue() {
		return rejectedValue;
	}

	public void setRejectedValue(Object rejectedValue) {
		this.rejectedValue = rejectedValue;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	ApiValidationError(String object, String message) {
		this.object = object;
		this.message = message;
	}

	public ApiValidationError(String object2, String field2, Object rejectedValue2, String message2) {
		this.object = object2;
		this.field = field2;
		this.rejectedValue = rejectedValue2;
		this.message = message2;
	}
	 
	
}
