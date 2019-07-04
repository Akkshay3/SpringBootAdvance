package com.springboot.exception;

public class InvalidHeaderFieldException extends RuntimeException{
  
  public InvalidHeaderFieldException(String msg) {
	super(msg);
  }
}
