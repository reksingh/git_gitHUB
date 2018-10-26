package com.sap.gs.seleniumframework;

import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import com.sap.gs.seleniumframework.data.AnnotationHandler;
import com.sap.gs.seleniumframework.data.DataService;
import com.sap.gs.seleniumframework.data.ProjectProperty;
import com.sap.gs.seleniumframework.data.PropertyModel;
import com.sap.gs.seleniumframework.data.PropertyService;

public class TestListener implements ITestListener{
	private PropertyService ps = PropertyService.getInstance();
	
	public void onStart(ITestContext context) {	
		//read parameters defined in test node in testng.xml
		DataService ds = DataService.getInstance();
		PropertyModel testPM = new PropertyModel();	
		testPM.setProperties(ds.readTestngParameters(context.getCurrentXmlTest().getAllParameters()));
		ps.configXmlTest(testPM);
	}

	public void onFinish(ITestContext context) {
		
	}

	public void onTestStart(ITestResult result) {
		String testName = "TEST CASE: " + result.getInstanceName() + "." + result.getMethod().getMethodName();		
		char[] chars = new char[testName.length() + 12];
		Arrays.fill(chars, '*');
		String str = new String(chars);
		System.out.println(str);
		System.out.println("***** " + testName + " *****");
		System.out.println(str);
		System.out.println();
		
		// TODO 
		// create test report entry

		//read test properties defined in annotations
		AnnotationHandler anno = new AnnotationHandler(result.getMethod());
		PropertyModel testMethodPM = new PropertyModel();
		testMethodPM.setProperties(anno.getProperties());
		ps.configTestMethod(testMethodPM);
	}

	public void onTestSuccess(ITestResult result) {
		cleanUp(result.getMethod());
	}

	public void onTestFailure(ITestResult result) {
		cleanUp(result.getMethod());
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	private void cleanUp(ITestNGMethod testNGMethod) {
		// Close browser automatically
		if(!PropertyService.getInstance().getProperty(ProjectProperty.BROWSER_AUTO_CLOSE).equalsIgnoreCase("false")) {
			SAPBaseTest test = (SAPBaseTest) testNGMethod.getInstance();
			if (test.getDriver() != null) {
				test.getDriver().quit();
			}
		}
	}
}
