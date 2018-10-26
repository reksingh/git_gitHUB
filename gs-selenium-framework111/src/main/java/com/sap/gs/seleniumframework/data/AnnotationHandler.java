package com.sap.gs.seleniumframework.data;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;

import org.testng.ITestNGMethod;
import com.sap.gs.seleniumframework.annotations.BrowserAutoClose;
import com.sap.gs.seleniumframework.annotations.BrowserType;
import com.sap.gs.seleniumframework.annotations.Credential;
import com.sap.gs.seleniumframework.annotations.LogIn;

/**
 * <p>
 * AnnotationHandler is used to retrieve customized annotation value for each test
 * </p>
 * <p>
 * Copyright (c) 2016 www.sap.com
 * </p>
 * 
 * @author i327002 peng.wang08@sap.com
 * @version 1.0
 */
public class AnnotationHandler {
	private ITestNGMethod testNGMethod;
	
	public AnnotationHandler(ITestNGMethod testNGMethod) {
		this.testNGMethod = testNGMethod;
	}
	
	public LinkedHashMap<String, String> getProperties() {
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		
		Method testMethod = testNGMethod.getConstructorOrMethod().getMethod();

		BrowserType browserType = testMethod.getAnnotation(BrowserType.class);
		if (browserType != null) {
			String type = browserType.value().toString();
			//System.out.println("[Test Property] browser.type=" + type);
			map.put(ProjectProperty.BROWSER_TYPE, type);
		}

		LogIn logInInfo = testMethod.getAnnotation(LogIn.class);
		if (logInInfo != null) {
			String className = logInInfo.className();
			String methodName = logInInfo.methodName();
			//System.out.println("[Test Property] test.login.class=" + className);
			map.put(ProjectProperty.TEST_LOGIN_CLASS, className);
			//System.out.println("[Test Property] test.login.method=" + methodName);
			map.put(ProjectProperty.TEST_LOGIN_METHOD, methodName);
		}

		Credential credential = testMethod.getAnnotation(Credential.class);
		if (credential != null) {
			String usr = credential.username();
			String pwd = credential.password();
			//System.out.println("[Test Property] test.username=" + usr);
			map.put(ProjectProperty.TEST_USERNAME, usr);
			//System.out.println("[Test Property] test.password=" + pwd);
			map.put(ProjectProperty.TEST_PASSWORD, pwd);
		}

		BrowserAutoClose bac = testMethod.getAnnotation(BrowserAutoClose.class);
		if (bac != null) {
			boolean flag = bac.value();
			//System.out.println("[Test Property] browser.autoclose=" + flag);
			map.put(ProjectProperty.BROWSER_AUTO_CLOSE, Boolean.toString(flag));
		}
		
		//TODO
		//add method for TestProperties annotation
		
		return map;
	}
}
