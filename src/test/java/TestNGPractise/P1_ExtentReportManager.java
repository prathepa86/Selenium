package TestNGPractise;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class P1_ExtentReportManager implements ITestListener{
	
	//UI of the report
	public ExtentSparkReporter sparkReporter; 
	//Populate commmon information of the report
	public ExtentReports extent;
	//Creating testcase entries and update the status
	public ExtentTest test;
	
	
	//This will get triggered before all the test cases and executes only once
	public void onStart(ITestContext context) {
		//Location of the report
		sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/htmlreport.html");
		//Title of the report
		sparkReporter.config().setDocumentTitle("Automation Report");
		//Name of the report
		sparkReporter.config().setReportName("Functional Testing");
		//Theme of the report Dark-black, Standard-White
		sparkReporter.config().setTheme(Theme.DARK);
		//Common information of the report
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Compute Name", "local host");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("TesterName", "Prathepa");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("BrowserName", "Chrome");		
	   
	  }
	
	public void onTestSuccess(ITestResult result) {
		//It will create new entry in the report
	   test=extent.createTest(result.getName());
	   //This will update status as pass and get the method name
	   test.log(Status.PASS,"Test case is passed:"+result.getName());
	  }
	
	public void onTestFailure(ITestResult result) {
	    //This will create a new entry in the report
		test=extent.createTest(result.getName());
		//This will update the status as well as get the name
		test.log(Status.FAIL, "Test case is Failed:"+result.getName());
	  }
	
	public void onTestSkipped(ITestResult result) {
	   test=extent.createTest(result.getName());
	   test.log(Status.SKIP, "Test case is skipped:"+result.getName());
	  }
	public void onFinish(ITestContext context) {
	    extent.flush();
	  }

	
	

	

}
