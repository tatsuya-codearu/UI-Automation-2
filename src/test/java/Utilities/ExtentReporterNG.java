package Utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	WebDriver driver;
	
	public static ExtentReports getReportObject() {
		String path = System.getProperty("user.dir")+"\\Reporting\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("UI Web Autmation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Vilasen Gounden");
		
		return extent;
	}
	
	/*public static String takeScreenshot(WebDriver driver) {
		try {
			String fileSeperator = System.getProperty("file,seperator");
			String extentReportsPath = System.getProperty("user.dir") 
					+ fileSeperator + "src" + fileSeperator + "test" + fileSeperator + "java" + fileSeperator + "reporting";
			String screenshotPath = extentReportsPath + fileSeperator + "screenshots";
			
			File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String screenshotName = "screenshot" + Math.random() + ".png";
			String screenshot = screenshotPath + fileSeperator + screenshotName;
			
			FileUtils.copyFile(file, new File(screenshot));
			return "." + fileSeperator + "screenshots" + fileSeperator + screenshotName;
		}catch(Exception ex){
			Assert.fail("test failed"+ ex);
			throw new RuntimeException(ex);
		}
		
	}*/

}
