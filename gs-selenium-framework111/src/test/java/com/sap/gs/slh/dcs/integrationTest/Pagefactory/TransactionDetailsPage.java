package com.sap.gs.slh.dcs.integrationTest.Pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransactionDetailsPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@id='__header1-innerTitle']")
	WebElement ReportingEntityTitle;
	
	@FindBy(xpath="//*[@id='application-OutwardSupply-savegstr1-component---transactions--pendInd-remainingBar']/span")
	WebElement NewInvoicesCount;
	
	@FindBy(xpath=".//*[@id='application-OutwardSupply-savegstr1-component---transactions--TransactionsPageLayout-anchBar-application-OutwardSupply-savegstr1-component---transactions--createdTransSec-anchor']")
	WebElement InProcessTab;
	
	@FindBy(xpath="//*[@id='__button12']")
	WebElement NewButtonLink;
	
	@FindBy(xpath="//*[@id='__mbox-btn-0']")
	WebElement NewFileOkButton;
	
	@FindBy(xpath="//*[@id='__status4-__table3-0-text']")
	WebElement CreatedTransactionStatus;
	
	@FindBy(xpath="//*[@id='__button19']")
	WebElement UploadToGSTNButton;
	
	@FindBy(xpath="//*[@id='__mbox-btn-2']")
	WebElement UploadFileOkButton;
	
	@FindBy(xpath="//*[@id='application-OutwardSupply-savegstr1-component---transactions--TransactionsPageLayout-anchBar-application-OutwardSupply-savegstr1-component---transactions--sentTransSec-anchor']")
	WebElement SentTab;
	
	@FindBy(xpath="//*[starts-with(@id, '__table0-tblBody')]/tr[1]/td[3]/div/span")
	WebElement SentinvoiceStatus;
	
	public TransactionDetailsPage(WebDriver driver){
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}
	
	
	public String getReportingEntityTitle(){
		return	ReportingEntityTitle.getText();
		
	}
	
	public String getNewInvoicesCount(){
		return	NewInvoicesCount.getText();
		
	}
	
	public void clickInProcessTab()
	{
		InProcessTab.click();
	}
	
	public void clickNewButtonLink()
	{
		NewButtonLink.click();
	}
	
	public void clickNewFileOkButton()
	{
		NewFileOkButton.click();
	}
	
	public String getCreatedTransactionStatus(){
		return	CreatedTransactionStatus.getText();
		
	}
	
	public void clickUploadToGSTNButton()
	{
		UploadToGSTNButton.click();
	}
	
	
	public void clickUploadFileOkButton()
	{
		UploadFileOkButton.click();
	}
	
	public void clickSentTab()
	{
		SentTab.click();
	}
	
	public String getSentinvoiceStatus(){
		return	SentinvoiceStatus.getText();
		
	}
	
	

}
