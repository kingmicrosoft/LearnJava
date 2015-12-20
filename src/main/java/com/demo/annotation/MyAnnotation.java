package com.demo.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by wisdom on 15-12-13.
 */
@Retention(value = RetentionPolicy.RUNTIME)

public @interface MyAnnotation {

 String value() default "test for annotation";
    String url();
}
