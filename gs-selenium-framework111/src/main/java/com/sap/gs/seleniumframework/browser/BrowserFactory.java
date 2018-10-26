package com.sap.gs.seleniumframework.browser;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.sap.gs.seleniumframework.data.ProjectProperty;
import com.sap.gs.seleniumframework.data.PropertyService;
import com.sap.gs.seleniumframework.util.SystemLogger;

/**
 * <p>Provide abilities to set browser properties and create instances</p>
 * <p>Copyright (c) 2016 www.sap.com</p>
 * 
 * @author i327002 peng.wang08@sap.com
 * @version 1.0
 */
public class BrowserFactory {
	private static Logger logger = SystemLogger.getLogger(BrowserFactory.class);
	
	public WebDriver getInstance() {	
		PropertyService ps = PropertyService.getInstance();
		String type = ps.getProperty(ProjectProperty.BROWSER_TYPE);
		boolean mode = Boolean.parseBoolean(ps.getProperty(ProjectProperty.SELENIUM_GRID));
		
		if (type.equalsIgnoreCase("firefox")) {
			return new FirefoxBrowser().startBrowser(mode);
		}
		else if (type.equalsIgnoreCase("chrome")) {
			return new ChromeBrowser().startBrowser(mode);
		}
		else if (type.equalsIgnoreCase("ie")) {
			return new IEBrowser().startBrowser(mode);
		}
		logger.info("Property 'browser.type' not defined or wrong. Use Chrome as default");
		return new ChromeBrowser().startBrowser(mode);	
	}
}
