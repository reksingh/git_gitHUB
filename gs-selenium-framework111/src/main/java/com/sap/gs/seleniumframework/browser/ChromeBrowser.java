package com.sap.gs.seleniumframework.browser;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.sap.gs.seleniumframework.data.ProjectProperty;
import com.sap.gs.seleniumframework.data.PropertyService;

/**
 * <p>Implementation of Chrome browsers; used to create Chrome instance</p>
 * <p>Copyright (c) 2016 www.sap.com</p>
 * 
 * @author i327002 peng.wang08@sap.com
 * @version 1.0
 */
public class ChromeBrowser implements IBrowser {
	private ChromeOptions options = new ChromeOptions();
	private PropertyService ps = PropertyService.getInstance();
	
	public WebDriver startBrowser(boolean mode) {
		if (mode==false) {
			return browserStandalone();
		}
		return browserGrid();
	}

	private WebDriver browserStandalone() {
		logger.info("Starting Chrome browser...");
		System.setProperty(ProjectProperty.CHROME_DRIVER, ps.getProperty(ProjectProperty.CHROME_DRIVER));
		
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		addChromeOptions();	
		capability.setCapability(ChromeOptions.CAPABILITY, options); 
		
		return new ChromeDriver(capability);
	}
	
	private WebDriver browserGrid() {
		WebDriver driver = null;
		String gridServer = ps.getProperty(ProjectProperty.SELENIUM_GRID_SERVER);
		logger.info("Starting Chrome browser in selenium grid mode...");
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		capability.setBrowserName("chrome");
		try {
			driver = new RemoteWebDriver(new URL(gridServer), capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
	}
	
	private void addChromeOptions() {
		if (!ps.getProperty(ProjectProperty.CHROME_ARGS).isEmpty()) {
			String para[] = ps.getProperty(ProjectProperty.CHROME_ARGS).split(";");
			for (String str:para) {
				if (!str.trim().isEmpty()) {
					logger.info("Adding Chrome Argument: " + str.trim());
					options.addArguments(str.trim());
				}	
			}
		}
		
		if (!ps.getProperty(ProjectProperty.CHROME_EXTS).isEmpty()) {
			String para[] = ps.getProperty(ProjectProperty.CHROME_EXTS).split(";");
			for (String str:para) {
				if (!str.trim().isEmpty()) {
					logger.info("Adding Chrome Extension: " + str.trim());
					options.addExtensions(new File(str.trim()));
				}	
			}
		}
		
		if (!ps.getProperty(ProjectProperty.CHROME_DOWNLOAD_DIR).isEmpty()) {
			HashMap<String, Object> prefs = new HashMap<String, Object>();
			//prefs.put("profile.default_content_settings.popups", 0);
			prefs.put("download.default_directory", ps.getProperty(ProjectProperty.CHROME_DOWNLOAD_DIR));
			options.setExperimentalOption("prefs", prefs);
		}
	}
}
