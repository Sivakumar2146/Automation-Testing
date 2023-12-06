package seleniumwebdriver.TestComponents;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import SeleiumWebDriver.resources.ExtendsReportNG;

public class Listeners extends BaseTest implements ITestListener{
	
	ExtentTest test;
	ExtentReports extent= ExtendsReportNG.getReportObject();
	
	
	@Override
	public void onTestStart(ITestResult result)
	{
		
		
	test = extent.createTest( result.getMethod().getMethodName() );
		
	}
	@Override
	public void onTestSuccess(ITestResult result)
	{
	
	//	test.log(Status.PASS, " Test Passed");
		
	}
	public void onTestFaliure (ITestResult result)
	{
		
		test.fail( result.getThrowable());
		//test.log(Status.FAIL, " Test Passed");
		//screenshot , Attach to report
		
	  String filepath = null;
	try {
		filepath = getScreenshot(result.getMethod().getMethodName(), driver );
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName() );
	}
	public void onTestSkipped (ITestResult result)
	{
		
		
		}
	
	
	
	
	
}
