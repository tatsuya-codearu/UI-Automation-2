package Application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Reporting.listeners;
import Utilities.Generic;

public class CompareProducts extends Generic{
	WebDriver driver;
	Home home;
	listeners lst = new listeners();
	
	
	public CompareProducts(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.home = new Home(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	@FindBy(xpath="//a[@aria-label='store logo']//img")
	WebElement hmpge;
	
	@FindBy(xpath="//thead//td[1]//a[1]")
	WebElement remove;
	
	@FindBy(xpath="//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	WebElement remConf;
	
	@FindBy(xpath="//span[normalize-space()='OK']")
	WebElement ok;
	
	
	
	public void comp1() {
		Logging lg = new Logging(driver);
		lg.verifyNotLogged();
		home.radiantTee();
		//scrollTo(home.radConf);
		home.compPge.click();
		//scrollTo(home.compRad);
		Assert.assertEquals(home.verifyRT(), home.compRad.getText());
		
	}
	
	public void comp2() throws InterruptedException {
		Logging lg = new Logging(driver);
		lg.verifyNotLogged();
		hmpge.click();
		home.breatheEz();
		home.compPge.click();
		Assert.assertEquals(home.verifyEZT(), home.compEZ.getText());
	}
	
	public void comp3() throws InterruptedException {
		Logging lg = new Logging(driver);
		lg.verifyNotLogged();
		hmpge.click();
		home.argusTank();
		home.compPge.click();
		hover(remove);
		click(remove);
		waitForElement(ok);
		lst.takeScreenshot(driver);
		hover(ok);
		click(ok);
		waitForElement(remConf);
		scrollTo(0,0);
		String msg = "You removed product Argus All-Weather Tank from the comparison list.";
		if (remConf.getText().equals(msg)) {
			lst.log("Argus All-Weather Tank successfulyl removed from compare products page");
			lst.takeScreenshot(driver);
		}else {
			lst.log("Confirmation message not found");
		}
		
		waitForElement(hmpge);
		scrollTo(0,0);
		hmpge.click();
	}

}
