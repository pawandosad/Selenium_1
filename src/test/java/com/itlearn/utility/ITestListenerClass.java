package com.itlearn.utility;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ITestListenerClass implements ITestListener {
	//ExtentReports is the main class in the ExtentReports library responsible for managing the entire reporting lifecycle. It aggregates all the test logs and results into a comprehensive report.
	//ExtentTest represents an individual test or a test case in the report. It logs information specific to that test, including steps, results (pass/fail), and media such as screenshots.
	//ExtentSparkReporter is a specific type of reporter in the ExtentReports library. It generates a modern, interactive HTML report with enhanced UI/UX features.

	ExtentSparkReporter htmlReporter; //ExtentSparkReporter is a powerful, modern reporter for the ExtentReports library, providing enhanced capabilities, better performance, and improved user experience. It is well-suited for generating detailed, interactive, and visually appealing test reports that can be easily integrated into various testing workflows and CI/CD pipelines.
	ExtentReports reports; //ExtentReports also used to generate report and attach those all reports.
	ExtentTest test; //ExtentReports helps generate interactive and detailed reports for automated test cases, providing insights into the test execution process.
	
	public void configureReport()
	{
		htmlReporter= new ExtentSparkReporter("ExtentListenerReportDemo.html"); // generating html report here of all test thing happend (either pass or fail).
		reports= new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		//add system information/environments info to reports
		reports.setSystemInfo("Machine", "RaviPc");
		reports.setSystemInfo("OS","Windows11");
		
		
		htmlReporter.config().setDocumentTitle("Extent Listener Report Demo");
		htmlReporter.config().setReportName("This is my first Report");
		htmlReporter.config().setTheme(Theme.DARK);
		
	}

	
	public void onTestStart(ITestResult result) {
	   
	  }

	
	  public void onTestSuccess(ITestResult result) {
	  System.out.println("Name of the test method successfully excuted "+result.getName());
	   test=reports.createTest(result.getName());
	   test.log(Status.PASS, MarkupHelper.createLabel("Name of the skip test case is: "+result.getName(),ExtentColor.GREEN));
	  }

	
	  public void onTestFailure(ITestResult result) {
	    System.out.println("Name of test method failed:"+result.getName());
	    test=reports.createTest(result.getName());
	    test.log(Status.FAIL, MarkupHelper.createLabel("Name of the skip test case is: "+result.getName(),ExtentColor.RED));
	    
	    String screenShotPath= System.getProperty("user.dir") +"\\ScreenShots\\" + result.getName() + ".png";
	    
	    File screenShotFile = new File(screenShotPath);
	    
	    if(screenShotFile.exists())
	    {
	    	test.fail("Captured Screenshot is below:" +test.addScreenCaptureFromPath(screenShotPath));
	    }
	  }


	  public void onTestSkipped(ITestResult result) {
	    System.out.println("Name of test method skipped "+result.getName());
	    test=reports.createTest(result.getName());
	    test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skip test case is: "+result.getName(),ExtentColor.YELLOW));
	  }


	  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	  
	  }

	
	  public void onTestFailedWithTimeout(ITestResult result) {
	    onTestFailure(result);
	  }

	 
	  public void onStart(ITestContext context) {
	    configureReport();
	    System.out.println("On start method invoked.....");
	  }

	
	  public void onFinish(ITestContext context) {
	    System.out.println("On Finished method invoked.....");
	    reports.flush();// it is mandatory to call flush method to ensure information is written ti the started reporter. 
	  }
}
