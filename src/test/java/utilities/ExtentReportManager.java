package utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener{

	public ExtentSparkReporter sparkReporter ; 
	public ExtentReports extent ; 
	public ExtentTest test ;
	
	String repName ;
	
	 public void onStart(ITestContext context) {
	 
		 String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		 repName = "Test-Report-" + timeStamp + ".html" ;
		  
		 sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);
		 
		 sparkReporter.config().setDocumentTitle("openCart Automation Report") ; 
		 sparkReporter.config().setReportName("openCart Functional Testing"); 
		 sparkReporter.config().setTheme(Theme.DARK);
		 
		 extent = new ExtentReports();
		 extent.attachReporter(sparkReporter);
		 extent.setSystemInfo("Application", "openCart");
		 extent.setSystemInfo("Module", "Admin");
		 extent.setSystemInfo("Sub Module", "Customers");
		 extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		 extent.setSystemInfo("User Name", System.getProperty("user.name"));
		 extent.setSystemInfo("Environment", "QA");
		 	 
	 }
	 
	 public void onTestSuccess(ITestResult result) { 
		 
		 test = extent.createTest(result.getName()); 
		 test.log(Status.PASS, "Test case PASSED is :" + result.getName()); //update the status pass , fail , skip	 
		 
	 }
	 
	public void onTestFailure(ITestResult result) {
		 
		 test = extent.createTest(result.getName()); 
		 test.log(Status.FAIL, "Test FAILED" );
		 test.log(Status.FAIL, result.getThrowable().getMessage());
		 
		 try {
			 
			String imgPath = new BaseClass().captureScreen(result.getTestName());
			 
		 }
		 
		 catch(IOException e1) {
			 
			 e1.printStackTrace();
		 }
	 }
	 
	 public void onTestSkipped(ITestResult result) { 
		 
		 test = extent.createTest(result.getName());
		 test.log(Status.SKIP,"Test Skipped");
		 test.log(Status.SKIP, result.getThrowable().getMessage());
	 }
	
	 public void onFinish(ITestContext context) { 
		 
		 extent.flush();
		 

	 }

	
}
