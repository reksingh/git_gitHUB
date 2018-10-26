package com.sap.gs.seleniumframework.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.sap.gs.seleniumframework.browser.Browser;

/**
 * <p>BrowserType annotation is used to setup which type of browser will be used for the method to run</p>
 * <p>Value in the annotation will overwrite 'browser.type' in project.properties</p>
 * <p>Copyright (c) 2016 www.sap.com</p>
 * 
 * @author i327002 peng.wang08@sap.com
 * @version 1.0
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface BrowserType {
	public Browser value() default Browser.CHROME;
}
