package com.jlf.testannotation;

import com.jlf.testannotation.validation.AsPassword;
import com.jlf.testannotation.validation.AsString;
import com.jlf.testannotation.validation.FieldName;
import com.jlf.testannotation.validation.ValidateObject;

public class LoginValidator extends ValidateObject{

	@FieldName("用户名")
	@AsString(min = 4, max = 20)
	public String name;
	
	@FieldName("密码")
	@AsPassword(min = 6, max = 16)
	public String password;
	
}
