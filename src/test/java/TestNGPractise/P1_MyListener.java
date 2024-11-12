package TestNGPractise;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class P1_MyListener implements ITestListener {
	public void onStart(ITestContext context) {
	    System.out.println("This will executed only once before all the test cases");
	  }
	
	public void onFinish(ITestContext context) {
	   System.out.println("This will executed only once after all the test cases");
	  }
	public void onTestStart(ITestResult result) {
	   System.out.println("This will executed before each test cases starts");
	  }
	public void onTestSuccess(ITestResult result) {
		System.out.println("This will executed when the test case pass");
	  }
	public void onTestFailure(ITestResult result) {
		System.out.println("This will executed when the test case fail");
	  }

}
