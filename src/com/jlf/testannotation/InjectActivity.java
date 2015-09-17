package com.jlf.testannotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import android.os.Bundle;
import android.view.View;

import com.jlf.testannotation.view.ContentView;
import com.jlf.testannotation.view.EventListener;
import com.jlf.testannotation.view.OnClick;
import com.jlf.testannotation.view.ViewID;

public class InjectActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		initContentView();
		initInjectView();
		initEventListener();
		
		initialize();
	}
	
	private void initContentView(){
		ContentView cv = getClass().getAnnotation(ContentView.class);
		if(cv != null){
			setContentView(cv.value());
		}
	}
	
	private void initInjectView(){
		View sourceView = getWindow().getDecorView();
		if(sourceView == null) return;
		
		Field[] fields = getClass().getDeclaredFields();
		for(Field field : fields){
			field.setAccessible(true);
			ViewID viewId = field.getAnnotation(ViewID.class);
			if(viewId != null){
				try {
					field.set(this, sourceView.findViewById(viewId.value()));
				} catch (IllegalAccessException | IllegalArgumentException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	private void initEventListener(){
		Method[] methods = getClass().getDeclaredMethods();
		
		for(Method method : methods){
			OnClick click = method.getAnnotation(OnClick.class);
			if(click != null){
				int[] viewId = click.value();
				EventListener listener = new EventListener(this, method);
				for(int i = 0; i < viewId.length; i++){
					View view = findViewById(viewId[i]);
					view.setOnClickListener(listener);
				}
			}
		}
	}
}
