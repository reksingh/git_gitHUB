package com.sap.gs;

import static com.jayway.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.sap.gs.seleniumframework.GSTR1ReqDC;
import com.sap.gs.seleniumframework.GSTR1ReqDC.Data;
import com.sap.gs.seleniumframework.SAPBaseTest;
import com.sap.gs.seleniumframework.browser.BrowserFactory;
import com.sap.gs.seleniumframework.data.ProjectProperty;
import com.sap.gs.seleniumframework.data.PropertyService;
import com.sap.gs.slh.dcs.integrationTest.Pagefactory.ASPHomePage;
import com.sap.gs.slh.dcs.integrationTest.Pagefactory.AuthenticationPage;
import com.sap.gs.slh.dcs.integrationTest.Pagefactory.HCPLoginPage;
import com.sap.gs.slh.dcs.integrationTest.Pagefactory.ReportingDashboardPage;
import com.sap.gs.slh.dcs.integrationTest.Pagefactory.ReportingEntityPage;

public class TestLoginWithPageFactory {
	
	
	public WebDriver driver;
	HCPLoginPage loginPage;
	ASPHomePage ASPHome;
	ReportingEntityPage ReportingEntity;
	AuthenticationPage authPage;
	ReportingDashboardPage dashBoard;
	PropertyService ps = PropertyService.getInstance();
	SAPBaseTest baseTest = new SAPBaseTest();

	
	@BeforeTest
	public void setup()
	{
		BrowserFactory browserfactory = new BrowserFactory();
		driver = browserfactory.getInstance();
		//driver  = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String url = ps.getProperty(ProjectProperty.TEST_URL);
		driver.get(url);

	}
	
	
	/**
	 * This test go to https://accounts.sap.com/saml2/idp/sso/accounts.sap.com
	 * Verify login page title as HCP
	 * Login to application
	 * Verify the home page using Home text
	 * Create Reporting Entity
	 * Add Report Categories 
	 * Assign activities to Reporting Entity
	 * Enable the online Communication with GSTIN by eDaas 
	 * @throws InterruptedException 
	 */
	@Test(priority=0)
	public void testLoginPage() throws InterruptedException
	{
		
		String user = ps.getProperty(ProjectProperty.TEST_USERNAME);
		String pwd = ps.getProperty(ProjectProperty.TEST_PASSWORD);
		
		//Create Login Page object
		loginPage = new HCPLoginPage(driver);
		
		//Verify login page title		
		String loginPageTitle =  loginPage.getLoginTitle();
		Assert.assertTrue(loginPageTitle.contains("SAP Cloud Platform"));
		
		//Login to application
		loginPage.loginToHCP(user, pwd);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		// Go the next page
		ASPHome = new ASPHomePage(driver);
		
		//Verify home page
		Assert.assertTrue(ASPHome.getHomePageDashboardUserName().contains("Home"));
		ASPHome.clickConfigurationPage();
		ReportingEntity = new ReportingEntityPage(driver);
		
		//Create New Reporting Entity
		ReportingEntity.clickAddNewEntryButton();
		ReportingEntity.setReportingEntity("AutoTest");
		ReportingEntity.setDescription("Automation testing");
		ReportingEntity.clickSaveButton();
		Thread.sleep(3000);
		
		// Edit Created Entity
		ReportingEntity.clickEditButton();
		waitForPageLoad();
		
		//Add report Categories (This test is for gstr1 report category)
		ReportingEntity.clickAddReportCategoriesButton();
		waitForPageLoad();
		ReportingEntity.clickSearchHelpForReportCategories();
		Thread.sleep(3000);
		ReportingEntity.clickReportCategories();
		Thread.sleep(3000);
		
		// Add User who can authorized to perform gstr1 activity
		ReportingEntity.clickAddUserButton();
		waitForPageLoad();
		ReportingEntity.clickSearchHelpForUser();
		Thread.sleep(3000);
		ReportingEntity.clickUser();
		Thread.sleep(3000);
		
		// Add GSTIN number with reporting entity
		ReportingEntity.clickAddParameter();
		waitForPageLoad();
		ReportingEntity.clickCalanderButton();
		Thread.sleep(3000);
		ReportingEntity.clickOnDate();
		waitForPageLoad();
		ReportingEntity.clickReportingLevelDropDown();
		Thread.sleep(3000);
		ReportingEntity.clickOnGSTNumber();
		waitForPageLoad();
		ReportingEntity.setParameterValue("04AABFN9870CMZT");
		waitForPageLoad();
		ReportingEntity.clickOnSaveEntityButton();
		Thread.sleep(3000);
		
		// Add Activities to Reporting Category like 'Save'
		ReportingEntity.clickReportingcategoryNavigation();
		Thread.sleep(3000);
		ReportingEntity.clickAddButtonForReportingActivity();
		Thread.sleep(3000);
		ReportingEntity.clickActivityArrow();
		waitForPageLoad();
		ReportingEntity.clickSaveActivity();
		waitForPageLoad();
		ReportingEntity.clickValidfromCalander();
		waitForPageLoad();
		ReportingEntity.clickActiveFromDate();
		waitForPageLoad();
		ReportingEntity.clickValidToCalander();
		waitForPageLoad();
		ReportingEntity.clickActiveToDate();
		waitForPageLoad();
		ReportingEntity.clickFinPeriodDropDown();
		waitForPageLoad();
		ReportingEntity.clickFinPeriod();
		Thread.sleep(3000);
		ReportingEntity.clickPeriodicityDropDown();
		waitForPageLoad();
		ReportingEntity.clickPeriodicity();
		waitForPageLoad();
		ReportingEntity.setNotificationIndicator("5");
		waitForPageLoad();
		ReportingEntity.setDueIndicator("5");
		waitForPageLoad();
		ReportingEntity.clickOnPeriodicityButton();
		Thread.sleep(3000);
		ReportingEntity.clickCategorySaveButton();
		Thread.sleep(3000);
		ReportingEntity.clickCategorynavButton();
		Thread.sleep(3000);
		
		//Enable the Online communication
//		ReportingEntity.clickEnableOnlineCommButton();
		Thread.sleep(3000);
		
		//Verify that Online communication is successfully completed for reporting entity
//		Assert.assertTrue(ReportingEntity.getEnableOnlineCommText().toLowerCase().contains("true"));
		
		//Goto Home Page
		ReportingEntity.clickHomeButton();
		
	}

	@Test(priority=1)
	public void testAuthentication() throws InterruptedException
	{
		// Click on Authentication Tile
		ASPHome.clickAuthenticationPage();
		Thread.sleep(4000);
		//Verify that Authentication Page is opened
		authPage = new AuthenticationPage(driver);
		
		String authPageTitle =  authPage.getAuthHomeTitle();
		Assert.assertTrue(authPageTitle.contains("Authenticate GST User"));

		//Edit Authentication Data and enter the valid use name 
		authPage.clickEditButton();
		Thread.sleep(3000);
		authPage.setUserName("GSTTESTUSER");
		authPage.clickSaveButton();
		Thread.sleep(3000);
		
		// Click on Authentication link for authenticate GSTIN ID
		authPage.clickAuthenticationLink();
		Thread.sleep(3000);
		authPage.setOTP("102030");
		authPage.clickOTPOkButton();
		Thread.sleep(3000);
		
		// Verify the Status of GSTIN number
		//Verify that Online communication is successfully completed for reporting entity
		Assert.assertTrue(authPage.getstatus().contains("EXPIRED"));
		
		//Goto Home Page
		ReportingEntity.clickHomeButton();
		
		
		
	}
	
	@Test(priority=1)
	public void testGSTReturns() throws InterruptedException
	{
		// Click on Authentication Tile
		ASPHome.clickReturnPage();
		Thread.sleep(4000);
		//Verify that Authentication Page is opened
		dashBoard = new ReportingDashboardPage(driver);
		dashBoard.clickReportingEntitylink();
		Thread.sleep(4000);
		
		
		
		
	}
	
	@Test(priority=2)
	public void testUploadInvoice()
	{
		System.setProperty("https.proxyHost","proxy02.ariba.com");
		System.setProperty("https.proxyPort","8080");
		GSTR1ReqDC req = new GSTR1ReqDC();
		req.setAction("UPLOAD");
		req.setTransid("trans_id_002");
		GSTR1ReqDC.Data data = new Data();
		data.setContent("ew0KICAiYjJiIjogew0KICAgICJiMmJpbnZvaWNlcyI6IFsNCiAgICAgIHsNCiAgICJnc3RpbiI6IjI3R1NQTUgwNzQyRzFaUiIsDQogICAiZnAiOiIwMjIwMTciLA0KICAgImN0aW4iOiIyN0dTUE1IMDc0MUcxWlMiLA0KICAgImludm51bSI6IklOMDAxIiwNCiAgICJpbnZkYXRlIjoiMjMtMTAtMjAxNiIsDQogICAibmlsdHlwZSI6Ik5HIiwNCiAgICJpbnZhbXQiOjUwMC4xNiwNCiAgICJwb3MiOiIyNyIsDQogICAicmV2Y2hyZyI6Ik4iLA0KICAgInByb3Zhc210IjoiTiIsDQogICAic3VwcGxpZXJzdGF0ZSI6IjAzIiwNCiAgICJpdGVtcyI6Ww0KICAgICB7DQoJICAgIm51bSI6MSwNCgkgICAidHlwZSI6IkciLA0KCSAgICJoc25zYWMiOiJHMTIyMSIsDQoJICAgInRheGJhc2UiOjEwMDAsDQoJICAgImlnc3RyYXRlIjowLA0KCSAgICJpZ3N0YW10IjowLA0KCSAgICJjZ3N0cmF0ZSI6MTAsDQoJICAgImNnc3RhbXQiOjEwMCwNCgkgICAic2dzdHJhdGUiOjEwLA0KCSAgICJzZ3N0YW10IjoxMDANCgkgfQ0KICAgIF0NCiAgICAgIH0NCiAgICBdDQogIH0NCn0=");
		data.setType("application/json");
		req.setData(data);
		Response resp = given().
				header("Content-Type", "application/json").
				header("Authorization", "Bearer a6c2888c5d564dc0667255d413945d6c").
				when().
				contentType(ContentType.JSON).
				body(req).
				post("https://dcsgstr1wef83d74c.int.sap.hana.ondemand.com/dcsgstr1/invoices");
		Assert.assertEquals(200, resp.getStatusCode());
		System.out.println(resp.asString());


	}
	
	@AfterTest
	public void shutdown()
	{
		driver.close();
	}
	
	public void waitForPageLoad() {

		   WebDriverWait wait = new WebDriverWait(driver, 5000);

		    wait.until(new ExpectedCondition<Boolean>() {
		        public Boolean apply(WebDriver wdriver) {
		            return ((JavascriptExecutor) driver).executeScript(
		                "return document.readyState"
		            ).equals("complete");
		        }
		    });
	}


}
