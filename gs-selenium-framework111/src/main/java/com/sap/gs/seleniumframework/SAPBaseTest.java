package com.sap.gs.seleniumframework;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

import com.sap.gs.seleniumframework.browser.BrowserFactory;
import com.sap.gs.seleniumframework.data.PropertyService;
import com.sap.gs.seleniumframework.data.DataService;
import com.sap.gs.seleniumframework.data.ProjectProperty;
import com.sap.gs.seleniumframework.util.SystemLogger;

/**
 * <p>All test case class should extend SAPBaseTest</p>
 * <p>Copyright (c) 2016 www.sap.com</p>
 * 
 * @author i327002 peng.wang08@sap.com
 * @version 1.0
 */
@Listeners({com.sap.gs.seleniumframework.TestListener.class, 
			com.sap.gs.seleniumframework.SuiteListener.class})
public class SAPBaseTest {
	public static Logger logger = SystemLogger.getLogger(SAPBaseTest.class);
	
	private WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Launch browser and maximize window
	 */
	public void start() {
		BrowserFactory factory = new BrowserFactory();
		driver = factory.getInstance();
		driver.manage().window().maximize();
	}

	/**
	 * Open URL in project.properties file. Construct page object with given page object class
	 * @param page
	 * @return
	 */
	public <T extends SAPBasePage> T navigateTo(Class<? extends SAPBasePage> page) {
		String url = PropertyService.getInstance().getProperty(ProjectProperty.TEST_URL);
		return navigateTo(page, url);
	}

	/**
	 * Open URL in parameter. Construct page object with given page object class.
	 * @param page
	 * @param url
	 * @return
	 */
	public <T extends SAPBasePage> T navigateTo(Class<? extends SAPBasePage> page, String url) {
		driver.get(url);
		logInSAP();
		return pageConstuctor(page);
	}

	/**
	 * Create page object by invoke its constructor. Class constructor should have WebDriver as parameter
	 * @param page
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private <T extends SAPBasePage> T pageConstuctor(Class<? extends SAPBasePage> page) {
		T t = null;
		Constructor<? extends SAPBasePage> cons = null;

		try {
			cons = page.getConstructor(WebDriver.class);
		} catch (NoSuchMethodException e1) {
			e1.printStackTrace();
		} catch (SecurityException e1) {
			e1.printStackTrace();
		}

		try {
			t = (T) cons.newInstance(driver);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		return t;
	}

	/**
	 * Use page object LogInPage to deal with login process. LogInPage should be customized for different login UI.
	 * LogIn will be ignored if property 'testing.login.page' is empty or 'testing.username' is empty
	 */
	private void logInSAP() {
		PropertyService ps = PropertyService.getInstance();
		String logInClass = ps.getProperty(ProjectProperty.TEST_LOGIN_CLASS);
		String logInMethod = ps.getProperty(ProjectProperty.TEST_LOGIN_METHOD);
		String user = ps.getProperty(ProjectProperty.TEST_USERNAME);
		String pwd = ps.getProperty(ProjectProperty.TEST_PASSWORD);

		if ((!logInClass.isEmpty()) && (!user.isEmpty())) {
			try {
				Object o = Class.forName(logInClass).getConstructor(WebDriver.class).newInstance(driver);
				Method m = Class.forName(logInClass).getMethod(logInMethod, String.class, String.class);
				m.invoke(o, user, pwd);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * Read test data from Excel file at first. </br>
	 * If there is no Excel file, then read the property from the file located at the same directory of test case
	 * 
	 * @param key 
	 * @return String
	 */
	public String getData(String key) {
		String name = this.getClass().getName();
		//String value = PropertyHandler.getTestData(name, key);
		
		String value = DataService.getInstance().getTestData(name, key);
		logger.info("[Test Data] " + key + "=" + value);
		return value;
	}

	/**
	 * get current time stamp based on format. format example: "yyyyMMddHHmmss"
	 * 
	 * @param dateFormat
	 * @return
	 */
	public String getTimeStamp(String dateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(new Date());
	}
}
