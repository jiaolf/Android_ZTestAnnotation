package com.jlf.testannotation.validation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class ValidateObject {
	
	private String message;
	
	public boolean isValide(){
		return message == null;
	}
	
	private Runnable successCallback;
	public void setSuccessCallback(Runnable callback){
		this.successCallback = callback;
	}
	
	private ValidationListener mValidationListener;
	public void setValidationListener(ValidationListener listener){
		this.mValidationListener = listener;
	}
	
	public void validate(){
		message = null;
		Field[] fields = getClass().getFields();
		for(Field field : fields){
			Annotation[] annotations = field.getAnnotations();
			if(annotations.length > 0){
				FieldName name = (FieldName) annotations[annotations[0] instanceof FieldName ? 0 : 1];
				Annotation validateAnnotation = annotations[annotations[0] instanceof FieldName ? 1 : 0];
				
				Validator validator = ValidatorCreater.create(validateAnnotation);
				Object data;
				try {
					data = field.get(this);
					validator.validat(data);
					if(!validator.isValide()){
						message = name.value() + validator.getMessage();
						mValidationListener.fail(message);
						return;
					}
				} catch (IllegalAccessException | IllegalArgumentException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
