package com.jlf.testannotation.validation;

public class StringToPatternValidation extends Validation {

	String pattern;
	
	public StringToPatternValidation(String pattern){
		this.pattern = pattern;
	}
	
	@Override
	public void validat(Object data) {
		String text = (String) data;
		if(!text.matches(pattern)){
			fail("输入格式错误");
		}
	}

}
