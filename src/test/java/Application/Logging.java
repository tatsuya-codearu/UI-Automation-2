package Application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Reporting.listeners;
import Utilities.Generic;

public class Logging extends Generic{
	WebDriver driver;
	listeners lst = new listeners();
	
	public Logging(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="div[class='panel header'] span[class='not-logged-in']")
	WebElement guest;
	
	public void verifyNotLogged() {
		waitForElement(guest);
		String msg = "Default welcome msg!";
		Assert.assertEquals(guest.getText(), msg);
		lst.log("User not logged in confirmed");
	}

}
