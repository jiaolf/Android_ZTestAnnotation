package com.jlf.testannotation.validation;

import java.lang.annotation.Annotation;

public class ValidatorCreater {

	public static Validator create(Annotation a){
		if(a instanceof AsString){
			return createValidator(new StringLengthValidation(((AsString) a).min(), ((AsString) a).max()));
		}else if(a instanceof AsPassword){
			return createValidator(new StringLengthValidation(((AsPassword) a).min(), ((AsPassword) a).max()));
		}else if(a instanceof Pattern){
			return createValidator(new StringToPatternValidation(((Pattern) a).regex()));
		}
		return null;
	}
	
	private static Validator createValidator(Validation... validations){
		return new Validator(validations);
	}
	
}
