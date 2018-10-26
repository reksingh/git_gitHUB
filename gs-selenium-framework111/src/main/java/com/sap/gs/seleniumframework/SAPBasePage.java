package com.sap.gs.seleniumframework;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.sap.gs.seleniumframework.data.ProjectProperty;
import com.sap.gs.seleniumframework.data.PropertyService;
import com.sap.gs.seleniumframework.util.SystemLogger;

/**
 * <p>All page objects should extend SAPBasePage</p>
 * <p>Copyright (c) 2016 www.sap.com</p>
 * 
 * @author i327002 peng.wang08@sap.com
 * @version 1.0
 */
public class SAPBasePage {
	protected WebDriver driver;
	protected static Logger logger = SystemLogger.getLogger(SAPBasePage.class);
	
	/**
	 * 
	 * Constructor
	 * @param driver WebDriver
	 */
	public SAPBasePage(WebDriver driver) {
		this.driver = driver;
		int waits = Integer.parseInt(PropertyService.getInstance().getProperty(ProjectProperty.IMPLICIT_WAITS));
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, waits);
		PageFactory.initElements(factory, this);
	}
	
	/**
	 * 
	 * Time to sleep
	 * @param milliseconds
	 */
	public void sleep(long milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Run JavaScript
	 * @param jscript
	 */
	public void runJavaScript(String jscript) {
		((JavascriptExecutor) driver).executeScript(jscript);
	}
	
	/**
	 * Run JavaScript on the given WebElement
	 * @param jscript
	 */
	public void runJavaScript(String jscript, WebElement element) {
		((JavascriptExecutor) driver).executeScript(jscript, element);
	}
	
	/**
	 * Get browser window title
	 * @return
	 */
	public String getTitle() {
		return driver.getTitle();
	}
}
