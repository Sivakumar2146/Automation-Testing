package SeleiumWebDriver.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
  
public class ExtendsReportNG {

	public static ExtentReports getReportObject()
	{
		  String path=	System.getProperty("user.dir")+"\\report\\index.html";
			ExtentSparkReporter reporter = new ExtentSparkReporter(path);
			reporter.config().setReportName("Web Automations");
			reporter.config().setDocumentTitle("Test Result");
		 
			ExtentReports extent =new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Tester", "Siva Pavi");
			extent.createTest(path);
			return extent;
	}
	
}
