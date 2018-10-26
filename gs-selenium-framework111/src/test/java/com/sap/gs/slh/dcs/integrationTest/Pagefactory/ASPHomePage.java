package com.sap.gs.slh.dcs.integrationTest.Pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ASPHomePage {
	
	WebDriver driver;
	@FindBy(xpath="//*[@id='shellAppTitle']/h1")
	WebElement ASPHomePage;
	
	@FindBy(id="__tile2")
	WebElement AuthenticationTile;
	
	@FindBy(id="__tile3")
	WebElement ConfigurationTile;
	
	@FindBy(id="__tile4")
	WebElement ReturnTile;
	
	@FindBy(id="__tile5")
	WebElement TrackInvoiceTile;
	
	public ASPHomePage(WebDriver driver){
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}
	
    private void waitForVisibility(WebElement element) throws Error{
        new WebDriverWait(driver, 60)
             .until(ExpectedConditions.visibilityOf(element));
    }
	
	//Get the User name from Home Page
	/*Initial loading, called when creating the page object to make sure that the page is loaded to a state 
	where it is ready to interact with us, in our case it means that button is present in DOM and visible*/
	public String getHomePageDashboardUserName(){
		waitForVisibility(ASPHomePage);
		return	ASPHomePage.getText();
		
	}
	
	public void clickAuthenticationPage()
	{
		AuthenticationTile.click();
	}
	
	public void clickConfigurationPage()
	{
		ConfigurationTile.click();
	}
	
	public void clickReturnPage()
	{
		ReturnTile.click();
	}
	
	public void clicktrackInvoicePage()
	{
		TrackInvoiceTile.click();
	}
		
	
	

}
