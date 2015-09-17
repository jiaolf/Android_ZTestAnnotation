package com.jlf.testannotation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jlf.testannotation.validation.ValidationListener;
import com.jlf.testannotation.view.OnClick;
import com.jlf.testannotation.view.ContentView;
import com.jlf.testannotation.view.ViewID;

@ContentView(R.layout.activity_main)
public class MainActivity extends InjectActivity{

	@ViewID(R.id.edit_name)	EditText etName;
	
	@ViewID(R.id.edit_pwd) EditText etPswd;
	
	@ViewID(R.id.btn_login)	Button btnLogin;
	
	@ViewID(R.id.btn_regist) Button btnRegist;
	
	LoginValidator validator = new LoginValidator();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	protected void initialize() {
		showToast("view 设置完毕");
	}
	
	// 标准的写法 public void login(View v), 可以没有参数
	// 一个的时候 @OnClick(R.id.btn_login), 多个的情况如下
	@OnClick({R.id.btn_login, R.id.btn_regist})
	void loginOrRegist(View v) {
		if(v.getId() == R.id.btn_login){
			if(validateInput()){
				String name = etName.getText().toString().trim();
				showToast(name + " on login ...");
			}
		}else if(v.getId() == R.id.btn_regist){
			showToast("register...");
		}
	}
	
	private boolean validateInput(){
		validator.name = etName.getText().toString().trim();
		validator.password = etPswd.getText().toString().trim();
		
		validator.setValidationListener(new ValidationListener() {
			
			@Override
			public void fail(String message) {
				showToast(message);
			}
		});
		
		validator.validate();
		
		return validator.isValide();
	}
}
