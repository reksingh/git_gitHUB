package com.sap.gs.slh.dcs.integrationTest.Pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReportingEntityPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@id='application-Reporting-Config-component---master--addAction-button']")
	WebElement AddEntityButton;
	
	@FindBy(xpath="//*[@id='reportingEntityAdd-inner']")
	WebElement ReportingentityTextBox;
	
	@FindBy(xpath="//*[@id='reportingEntityDescAdd-inner']")
	WebElement DescriptionTextBox;
	
	@FindBy(xpath="//*[@id='__button13']")
	WebElement SaveButton;
	
	@FindBy(xpath="//*[@id='application-Reporting-Config-component---detail--viewEdit']")
	WebElement EditButton;
	
	@FindBy(xpath="//*[@id='application-Reporting-Config-component---detail--addCategory']")
	WebElement AddReportCategoriesButton;
	
	@FindBy(xpath="//*[@class='sapMInputValHelpInner sapUiIcon sapUiIconMirrorInRTL sapUiIconPointer']")
	WebElement SearchHelpForReportCategories;
	
	@FindBy(xpath="//*[@id='__table0-rowsel0']")
	WebElement SelectReportCategories;
	
	@FindBy(xpath="//*[@id='application-Reporting-Config-component---detail--addUser']")
	WebElement AddUserButton;
	
	@FindBy(xpath="//*[starts-with(@id, 'application-Reporting-Config-component---detail--usertable-tblBody')]/tr[1]/td[3]/div")
	WebElement SearchHelpForUser;
	
	@FindBy(xpath="//*[@id='__table1-rowsel1']")
	WebElement SelectUser;
	
	@FindBy(xpath="//*[@id='application-Reporting-Config-component---detail--addParam2']")
	WebElement AddParameter;
	
	@FindBy(xpath="//*[@class='sapMInputValHelpInner sapUiIcon sapUiIconMirrorInRTL']")
	WebElement CalanderButton;
	
	@FindBy(xpath="//*[starts-with(@aria-label, 'May 1, 2017')]")
	WebElement SelectDate;
	
	@FindBy(xpath="//*[@class='sapMSltArrow']")
	WebElement ReportingLevelDropDown;
	
	@FindBy(xpath="//*[@class='sapMSelectListItem sapMSelectListItemBase sapMSelectListItemBaseHoverable']")
	WebElement SelectGSTNumber;
	
	@FindBy(xpath="//*[starts-with(@id, 'application-Reporting-Config-component---detail--reportingleveltable-tblBody')]/tr[1]/td[5]/div/input")
	WebElement ParameterValue;
	
	@FindBy(xpath="//*[@id='application-Reporting-Config-component---detail--viewSave']")
	WebElement SaveEntityButton;
	
	@FindBy(xpath="//*[starts-with(@id, 'application-Reporting-Config-component---detail--categoryTable-listUl')]/tbody/tr[1]/td[5]")
	WebElement ReportingcategoryNavigation;
	
	@FindBy(xpath="//*[@id='application-Reporting-Config-component---Category--addPeriod']")
	WebElement AddButtonForReportingActivity;
	
	@FindBy(xpath="//*[@id='activityFrag-arrow']")
	WebElement ActivityArrow;
	
	@FindBy(xpath="//*[@class='sapMSelectList sapMSltList-CTX']/li[1]")
	WebElement SelectSaveActivity;
	
	@FindBy(xpath="//*[@id='fromdate-icon']")
	WebElement ValidfromCalander;
	
	@FindBy(xpath="//*[@id='fromdate-cal--Month0-20170501']/span")
	WebElement SelectActiveFromDate;
	
	@FindBy(xpath="//*[@id='todate-icon']")
	WebElement ValidToCalander;
	
	@FindBy(xpath="//*[@id='todate-cal--Month0-20170531']/span")
	WebElement SelectActiveToDate;
	
	@FindBy(xpath="//*[@id='StartPeriod-arrow']")
	WebElement FinPeriodDropDown;
	
	@FindBy(xpath="//li[contains(@id,'-StartPeriod-3')]")
	WebElement SelectFinPeriod;
	
	@FindBy(xpath="//*[@id='PeriodicityFrag-arrow']")
	WebElement PeriodicityDropDown;
	
	@FindBy(xpath="//li[contains(@id,'PeriodicityFrag-0')]")
	WebElement SelectPeriodicity;
	
	@FindBy(xpath="//*[@id='offsetFrag-inner']")
	WebElement DueIndicatorTextbox;
	
	@FindBy(xpath="//*[@id='fyVarianttFrag-inner']")
	WebElement NotificationIndicatorTextBox;
	
	@FindBy(xpath="//*[@id='onAddPeriodicityButton']")
	WebElement AddPeriodicityButton;
	
	@FindBy(xpath="//*[@id='application-Reporting-Config-component---Category--viewSave']")
	WebElement CategorySaveButton;
	
	@FindBy(xpath="//*[@id='application-Reporting-Config-component---Category--CategoryId-navButton']")
	WebElement CategorynavButton;
	
	@FindBy(xpath="//*[@id='application-Reporting-Config-component---detail--onlineRegisteration']")
	WebElement EnableOnlineCommButton;
	
	@FindBy(xpath="//*[@id='__text9-inner']")
	WebElement EnableOnlineCommText;
	
	@FindBy(xpath="//*[@id='homeBtn']/span")
	WebElement HomeButton;
	
	
	public ReportingEntityPage(WebDriver driver){
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}
	
	private void waitForVisibility(WebElement element) throws Error{
	        new WebDriverWait(driver, 5000)
	             .until(ExpectedConditions.visibilityOf(element));
	    }
	
	//Click on "+" icon to add new Entity
	public void clickAddNewEntryButton()
	{
		waitForVisibility(AddEntityButton);
		AddEntityButton.click();
	}
	
	public void setReportingEntity(String setReportingEntity)
	{
		waitForVisibility(ReportingentityTextBox);
		ReportingentityTextBox.sendKeys(setReportingEntity);
		
	}
	
	public void setDescription(String setDescription)
	{
		waitForVisibility(DescriptionTextBox);
		DescriptionTextBox.sendKeys(setDescription);
		
	}
	
	public void clickSaveButton()
	{
		waitForVisibility(SaveButton);
		SaveButton.click();
	}
	
	public void clickEditButton()
	{
		waitForVisibility(EditButton);
		EditButton.click();
	}
	
	public void clickAddReportCategoriesButton()
	{
		waitForVisibility(AddReportCategoriesButton);
		AddReportCategoriesButton.click();
	}
	
	public void clickSearchHelpForReportCategories()
	{
		waitForVisibility(SearchHelpForReportCategories);
		SearchHelpForReportCategories.click();
	}
	
	public void clickReportCategories()
	{
		waitForVisibility(SelectReportCategories);
		SelectReportCategories.click();
	}
	
	public void clickAddUserButton()
	{
		waitForVisibility(AddUserButton);
		AddUserButton.click();
	}
	
	public void clickSearchHelpForUser()
	{
		waitForVisibility(SearchHelpForUser);
		SearchHelpForUser.click();
	}
	
	public void clickUser()
	{
		waitForVisibility(SelectUser);
		SelectUser.click();
	}
	
	public void clickAddParameter()
	{
		waitForVisibility(AddParameter);
		AddParameter.click();
	}
	
	public void clickCalanderButton()
	{
		waitForVisibility(CalanderButton);
		CalanderButton.click();
	}
	
	public void clickOnDate()
	{
		waitForVisibility(SelectDate);
		SelectDate.click();
	}
	
	public void clickReportingLevelDropDown()
	{
		waitForVisibility(ReportingLevelDropDown);
		ReportingLevelDropDown.click();
	}
	
	public void clickOnGSTNumber()
	{
		waitForVisibility(SelectGSTNumber);
		SelectGSTNumber.click();
	}
	
	public void setParameterValue(String setParameterValue)
	{
		waitForVisibility(ParameterValue);
		ParameterValue.sendKeys(setParameterValue);
		
	}
	
	public void clickOnSaveEntityButton()
	{
		waitForVisibility(SaveEntityButton);
		SaveEntityButton.click();
	}
	
	public void clickReportingcategoryNavigation()
	{
		waitForVisibility(ReportingcategoryNavigation);
		ReportingcategoryNavigation.click();
	}
	
	public void clickAddButtonForReportingActivity()
	{
		waitForVisibility(AddButtonForReportingActivity);
		AddButtonForReportingActivity.click();
	}
	
	public void clickActivityArrow()
	{
		waitForVisibility(ActivityArrow);
		ActivityArrow.click();
	}
	
	public void clickSaveActivity()
	{
		waitForVisibility(SelectSaveActivity);
		SelectSaveActivity.click();
	}
	
	public void clickValidfromCalander()
	{
		waitForVisibility(ValidfromCalander);
		ValidfromCalander.click();
	}
	public void clickActiveFromDate()
	{
		waitForVisibility(SelectActiveFromDate);
		SelectActiveFromDate.click();
	}
	
	public void clickValidToCalander()
	{
		waitForVisibility(ValidToCalander);
		ValidToCalander.click();
	}
	public void clickActiveToDate()
	{
		waitForVisibility(SelectActiveToDate);
		SelectActiveToDate.click();
	}
	
	public void clickFinPeriodDropDown()
	{
		waitForVisibility(FinPeriodDropDown);
		FinPeriodDropDown.click();
	}
	public void clickFinPeriod()
	{
		waitForVisibility(SelectFinPeriod);
		SelectFinPeriod.click();
	}
	
	public void clickPeriodicityDropDown()
	{
		waitForVisibility(PeriodicityDropDown);
		PeriodicityDropDown.click();
	}
	public void clickPeriodicity()
	{
		waitForVisibility(SelectPeriodicity);
		SelectPeriodicity.click();
	}
	
	public void setNotificationIndicator(String setNotificationIndicator)
	{
		waitForVisibility(NotificationIndicatorTextBox);
		NotificationIndicatorTextBox.sendKeys(setNotificationIndicator);
		
	}
	
	public void setDueIndicator(String setDueIndicator)
	{
		waitForVisibility(DueIndicatorTextbox);
		DueIndicatorTextbox.sendKeys(setDueIndicator);
		
	}
	public void clickOnPeriodicityButton()
	{
		waitForVisibility(AddPeriodicityButton);
		AddPeriodicityButton.click();
	}
	
	public void clickCategorySaveButton()
	{
		waitForVisibility(CategorySaveButton);
		CategorySaveButton.click();
	}

	public void clickCategorynavButton()
	{
		waitForVisibility(CategorynavButton);
		CategorynavButton.click();
	}
	
	public void clickEnableOnlineCommButton()
	{
		waitForVisibility(EnableOnlineCommButton);
		EnableOnlineCommButton.click();
	}
	
	public String getEnableOnlineCommText(){
		waitForVisibility(EnableOnlineCommText);
		return	EnableOnlineCommText.getText();
		
	}
	
	public void clickHomeButton()
	{
		HomeButton.click();
	}



}
