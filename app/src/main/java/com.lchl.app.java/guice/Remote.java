package com.lchl.app.java.guice;

import com.google.inject.BindingAnnotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * <pre>
 * Brief descriptions for the file.
 * User: chaohua.luo
 * Date: 12-5-15
 * Time: 下午12:06
 * </pre>
 */
@Retention(RetentionPolicy.RUNTIME)
@BindingAnnotation
public @interface Remote {
}
