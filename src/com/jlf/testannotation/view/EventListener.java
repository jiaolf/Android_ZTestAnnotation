package com.jlf.testannotation.view;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.view.View;
import android.view.View.OnClickListener;

public class EventListener implements OnClickListener {

	private Object handler;
	private Method method;
	
	@Override
	public void onClick(View v) {
		try {
			method.setAccessible(true);
			if(method.getParameterTypes().length > 0){
				method.invoke(handler, v);
			}else{
				method.invoke(handler, null);
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public EventListener(Object target, Method method) {
		this.handler = target;
		this.method = method;
	}
	
}
