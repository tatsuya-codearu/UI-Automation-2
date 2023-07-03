package Reporting;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utilities.ExtentReporterNG;

public class listeners extends BaseTest implements ITestListener{
	WebDriver driver;
	static ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReportObject();

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, "Test Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test.fail(result.getThrowable());
		takeScreenshot(driver);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.SKIP, "Test Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}
	
	public void takeScreenshot(WebDriver driver) {
		try {
	        if (driver == null) {
	            throw new IllegalArgumentException("WebDriver instance is null");
	        }
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File file = ts.getScreenshotAs(OutputType.FILE);
			String scpath ="C:\\Users\\gvila\\Selenium\\Automation_Assessment_2\\Reporting\\";
			String scimg = "screenshot" + Math.random() + ".png";
			String screenshot = scpath + scimg;
			FileUtils.copyFile(file, new File(screenshot));
			test.addScreenCaptureFromPath(screenshot);
			
		}catch(Exception ex){
			Assert.fail("test failed"+ ex);
			throw new RuntimeException(ex);
		}
		
	}
	
	public void log(String desc) {
		test.log(Status.INFO, desc);
	}



}
