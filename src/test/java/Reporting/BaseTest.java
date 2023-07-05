package Reporting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
	WebDriver driver;
	
	//@Optional(value="browser")
	@BeforeClass
	@Parameters({"browser", "url"})
	public void initializeDriver(@Optional("firefox")String browser, String url) {

		switch(browser) {
			case "firefox":
				System.setProperty("webdriver.firefox.driver", "C:\\Users\\gvila\\Documents\\drivers\\geckodriver");
				driver = new FirefoxDriver();
				break;
			
			case "chrome":
				driver = new ChromeDriver();
				break;
				
			case "edge":
				driver = new EdgeDriver();
				break;
		}
		
		
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}

}

