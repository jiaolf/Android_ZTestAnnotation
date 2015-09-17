package com.jlf.testannotation.validation;

public abstract class Validation {
	
	public boolean isValidate(){
		return message == null;
	}
	
	private String message;
	public String getMessage(){
		return message;
	}
	
	public abstract void validat(Object data);
	
	public void fail(String message){
		this.message = message;
	}
}
