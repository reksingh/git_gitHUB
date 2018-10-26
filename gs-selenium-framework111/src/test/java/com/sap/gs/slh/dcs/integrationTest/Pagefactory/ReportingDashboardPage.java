package com.sap.gs.slh.dcs.integrationTest.Pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportingDashboardPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//*[starts-with(@id, 'application-Reporting-Run-component---reportListPage--reportingTable-tblBody')]/tr[1]/td[8]/span")
	WebElement ReportingEntitylink;
	
	public ReportingDashboardPage(WebDriver driver){
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}
	
	public void clickReportingEntitylink()
	{
		ReportingEntitylink.click();
	}

}
