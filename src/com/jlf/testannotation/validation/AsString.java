package com.jlf.testannotation.validation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface AsString {
	int min() default 1;
	int max() default 20;
	String message() default "";
}
