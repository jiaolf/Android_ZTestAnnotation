package com.jlf.testannotation;


import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;

public class BaseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void setContentView(int layoutResID) {
		super.setContentView(layoutResID);
	}
	
	protected void initialize() {
	}


	public void showToast(String text) {
		final String txt = text;
		if(Looper.myLooper() == getMainLooper()){
			Toast.makeText(this, txt, Toast.LENGTH_SHORT).show();
		}else{
			runOnUiThread(new Runnable(){
				@Override
				public void run() {
					Toast.makeText(getBaseContext(), txt, Toast.LENGTH_SHORT).show();
				}
			});
		}
	}
}
