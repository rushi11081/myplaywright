package library;

import java.nio.file.Paths;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.microsoft.playwright.Page;

public class Librararylistener implements ITestListener {

	public static ExtentTest test;
    ExtentReports extent = library.Libextentreport.getreport();
	
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = extent.createTest(result.getMethod().getMethodName()).assignAuthor("rushikesh");
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub.
		test.log(Status.PASS, "Test Passed");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub

		test.fail(result.getThrowable());
		
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screen5.png")));

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.fail(result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}
