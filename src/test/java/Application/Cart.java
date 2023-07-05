package Application;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Reporting.listeners;
import Utilities.Generic;

public class Cart extends Generic{
	WebDriver driver;
	
	
	
	public Cart(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="button[title='Proceed to Checkout'] span")
	WebElement proceed;
	
	public void chckout(String testid) throws IOException {
		listeners lst = new listeners();
		Tees tee = new Tees(driver);
		tee.test6(testid);
		lst.takeScreenshot(driver);
		waitForElement(proceed);
		proceed.click();
		
	}

}
