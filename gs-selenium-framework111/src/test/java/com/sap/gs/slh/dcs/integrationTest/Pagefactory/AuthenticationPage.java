package com.sap.gs.slh.dcs.integrationTest.Pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthenticationPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@id='application-GSTNUser-authenticate-component---worklist--page-title-inner']")
	WebElement AuthHomeText;
	
	@FindBy(xpath="//*[starts-with(@id, 'application-GSTNUser-authenticate-component---worklist--table-tblBody')]/tr[1]/td[7]")
	WebElement EditButton;
	
	@FindBy(xpath="//*[@id='editUserNameInp-inner']")
	WebElement UserNameTextBox;
	
	@FindBy(xpath="//footer[starts-with(@id,'edocTypeAddDialog-footer')]/button[1]")
	WebElement SaveButton;
	
	@FindBy(xpath="//*[starts-with(@id, 'application-GSTNUser-authenticate-component---worklist--table-tblBody')]/tr[1]/td[6]/a")
	WebElement AuthenticationLink;
	
	@FindBy(xpath="//*[@id='OTPInp-inner']")
	WebElement OTPTextBox;
	
	@FindBy(xpath="//*[@id='OTPOkBtn']")
	WebElement OTPOkButton;
	
	@FindBy(xpath="//*[starts-with(@id, 'application-GSTNUser-authenticate-component---worklist--table-tblBody')]/tr[1]/td[5]/div/span")
	WebElement status;
	
	@FindBy(xpath="//*[@id='backBtn']/span")
	WebElement BackButton;
	
	public AuthenticationPage(WebDriver driver){
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}
	
	//Get the title of Login Page
	public String getAuthHomeTitle()
	{
		return AuthHomeText.getText();
	}
	
	public void clickEditButton()
	{
		EditButton.click();
	}
	
	public void setUserName(String setUserName)
	{
		UserNameTextBox.sendKeys(setUserName);
		
	}
	
	public void clickSaveButton()
	{
		SaveButton.click();
	}
	
	public void clickAuthenticationLink()
	{
		AuthenticationLink.click();
	}
	
	public void setOTP(String setOTP)
	{
		OTPTextBox.sendKeys(setOTP);
		
	}
	
	public void clickOTPOkButton()
	{
		OTPOkButton.click();
	}
	
	public String getstatus(){
		return	status.getText();
		
	}
	
	public void clickBackButton()
	{
		BackButton.click();
	}

}
