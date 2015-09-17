package com.jlf.testannotation.validation;

public class StringLengthValidation extends Validation {

	private int min;
	private int max;
	
	public StringLengthValidation(int min, int max) {
		this.min = min;
		this.max = max;
	}

	@Override
	public void validat(Object data) {
		String text = (String) data;
		if(text == null || text.length() == 0){
			fail("不能为空");
			return;
		}
		
		if(text.length() < min){
			fail(String.format("长度不能少于%s位", min));
		}else if(text.length() > max){
			fail(String.format("长度不能超过%s位", max));
		}
	}

}
