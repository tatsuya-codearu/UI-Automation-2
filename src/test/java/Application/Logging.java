package Application;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Reporting.listeners;
import Utilities.ExcelData;
import Utilities.Generic;

public class Logging extends Generic{
	WebDriver driver;
	listeners lst = new listeners();
	ExcelData xl = new ExcelData();
	
	public Logging(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='panel header']//a[contains(text(),'Sign In')]")
	WebElement signin;
	
	@FindBy(css="#email")
	WebElement email;
	
	@FindBy(xpath="//fieldset[@class='fieldset login']//input[@id='pass']")
	WebElement pass;
	
	@FindBy(css="fieldset[class='fieldset login'] div[class='primary'] span")
	WebElement btnsign;
	
	public void verifyNotLogged() {
		waitForElement(signin);
		String msg = "Sign In";
		Assert.assertEquals(signin.getText(), msg);
	 	lst.log("User not logged in confirmed");
	}
	
	public void login(String testid) throws IOException {
		hover(signin);
		click(signin);
		waitForElement(email);
		email.clear();
		pass.clear();
		email.sendKeys(xl.xlData(testid, "username").toString());
		pass.sendKeys(xl.xlData(testid, "password").toString());
		lst.takeScreenshot(driver);
		btnsign.click();
	}

}
