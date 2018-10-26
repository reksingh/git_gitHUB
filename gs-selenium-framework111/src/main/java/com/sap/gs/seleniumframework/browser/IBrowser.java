package com.sap.gs.seleniumframework.browser;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.sap.gs.seleniumframework.util.SystemLogger;

/**
 * <p>interface to all browsers</p>
 * <p>Copyright (c) 2016 www.sap.com</p>
 * 
 * @author i327002 peng.wang08@sap.com
 * @version 1.0
 */
public interface IBrowser {
	Logger logger = SystemLogger.getLogger(IBrowser.class);
	WebDriver startBrowser(boolean mode);
}
