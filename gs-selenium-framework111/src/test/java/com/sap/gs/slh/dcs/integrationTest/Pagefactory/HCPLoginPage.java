package com.sap.gs.slh.dcs.integrationTest.Pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sap.gs.slh.dcs.gstr1.seleniumFramework.data.ProjectProperty;
import com.sap.gs.slh.dcs.gstr1.seleniumFramework.data.PropertyService;


public class HCPLoginPage {
	/**
	 * All WebElements are identified by @FindBy annotation
	 */
	
	WebDriver driver;
	PropertyService ps = PropertyService.getInstance();
	String user = ps.getProperty(ProjectProperty.TEST_USERNAME);
	String pwd = ps.getProperty(ProjectProperty.TEST_PASSWORD);
	
	@FindBy(name="j_username")
	WebElement HCPUserName;
	
	@FindBy(name="j_password")
	WebElement HCPPassword;
	
	@FindBy(xpath="//*[@id='test-service-provider-name']")
	WebElement titleText;
	
	@FindBy(id="logOnFormSubmit")
	WebElement logOn;
	
	public HCPLoginPage(WebDriver driver)
	{
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}

	//Set user name in textbox
	public void setUserName(String setUserName)
	{
		HCPUserName.sendKeys(setUserName);
	}
	
	//Set Password in textbox
	public void setPassword(String setPassword)
	{
		HCPPassword.sendKeys(setPassword);
	}
	
	//Click on Log On button
	public void clickLogin()
	{
		logOn.click();
	}

	//Get the title of Login Page
	public String getLoginTitle()
	{
		return titleText.getText();
	}
	
	/**
	 * This POM method will be exposed in test case to login in the application
	 * @param strUserName
	 * @param strPasword
	 * @return
	 */
	
	public void loginToHCP(String setUserName, String setPassword)
	{
		//Fill user name
		this.setUserName(setUserName);
		//Fill Password
		this.setPassword(setPassword);
		//Click on Log On button
		this.clickLogin();
	}

}
