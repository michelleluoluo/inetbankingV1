package com.inetbanking.utilities;


//Listener Class used to generate a test report
import java.io.File;
//import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Reporting extends TestListenerAdapter{

	public ExtentSparkReporter spark;
	public ExtentReports extentRep;
	public ExtentTest extenttestlog;
	
	public void onStart(ITestContext testContext)
	{
		String timesStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName = "Test-Report" + timesStamp + ".html";
		String filepath =  System.getProperty("user.dir") + "/test-output/"+ repName;
		System.out.println(filepath);
			
		extentRep = new ExtentReports();
		spark = new ExtentSparkReporter(filepath);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("InetBanking Test Project");
		spark.config().setReportName("Functional Test Automation Report");
		extentRep.attachReporter(spark);
	}
	
	public void onTestSuccess(ITestResult tr)
	{
	
	
		extenttestlog = extentRep.createTest(tr.getName()).assignAuthor("Michelle").assignCategory("Regression").assignDevice("chrome 88");
		System.out.println(tr.getName());
//		extenttestlog.pass("test passed!");
		extenttestlog.log(Status.PASS, MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
		
	}
	
	public void onTestFailure(ITestResult tr) {

		extenttestlog = extentRep.createTest(tr.getName()).assignAuthor("Michelle").assignCategory("Regression").assignDevice("chrome 88");
		extenttestlog.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
		System.out.println("test fail");
		String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + tr.getName() + ".png";
		
		File f = new File(screenshotPath);
		
		if(f.exists())
		{
//			try {
			extenttestlog.fail("Screenshot is below:" + extenttestlog.addScreenCaptureFromPath(screenshotPath));
//			}
//			catch(IOException e) {
//				e.printStackTrace();
//			}
		}
	}
	
	public void onTestSkipped(ITestResult tr)
	{	
	
		extenttestlog = extentRep.createTest(tr.getName()).assignAuthor("Michelle").assignCategory("Regression").assignDevice("chrome 88");
		System.out.println("test skipped");
		extenttestlog.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
		
	}
	 
	public void onFinish(ITestContext testContext)
	{
		System.out.println("finish");
		extentRep.flush();
	}
}


