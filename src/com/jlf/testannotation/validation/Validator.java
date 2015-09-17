package com.jlf.testannotation.validation;

public class Validator {

	private String message;
	public String getMessage(){
		return message;
	}
	
	public boolean isValide(){
		return message == null;
	}
	
	private Validation[] validations;
	public Validator(Validation... validations){
		this.validations = validations;
	}
	
	public void validat(Object data){
		for(Validation validation : validations){
			validation.validat(data);
			if(!validation.isValidate()){
				this.message = validation.getMessage();
				break;
			}
		}
	}
}
