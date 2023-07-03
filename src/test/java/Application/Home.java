package Application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Reporting.listeners;
import Utilities.Generic;

public class Home extends Generic {
	WebDriver driver;
	listeners lst = new listeners();

	public Home(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[normalize-space()='Hot Sellers']")
	WebElement hs;

	@FindBy(xpath = "//a[normalize-space()='Radiant Tee']")
	WebElement rad;

	@FindBy(xpath = "//li[1]//div[1]//div[1]//div[4]//div[1]//div[2]//a[2]")
	WebElement radComp;

	// You added product Radiant Tee to the comparison list.
	@FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	WebElement radConf;

	@FindBy(xpath = "//a[@title='Compare Products']")
	WebElement compPge;

	@FindBy(xpath = "//a[normalize-space()='Radiant Tee']")
	WebElement compRad;

	@FindBy(xpath = "//a[normalize-space()='Breathe-Easy Tank']")
	WebElement ezT;

	@FindBy(xpath = "//li[2]//div[1]//div[1]//div[4]//div[1]//div[2]//a[2]")
	WebElement ezTComp;

	@FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	WebElement ezConf;
	
	@FindBy(xpath="//a[normalize-space()='Breathe-Easy Tank']")
	WebElement compEZ;
	
	@FindBy(xpath="//a[normalize-space()='Argus All-Weather Tank']")
	WebElement argus;
	
	@FindBy(xpath="//li[3]//div[1]//div[1]//div[3]//div[1]//div[2]//a[2]")
	WebElement argusComp;
	
	@FindBy(xpath="//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	WebElement argusConf;
	
	@FindBy(xpath="//a[@title='Remove Product']")
	WebElement compRem;

	public void radiantTee() {
		scrollTo(0, 1600);
		lst.takeScreenshot(driver);
		waitForElement(rad);
		hover(rad);
		lst.takeScreenshot(driver);
		waitForElement(radComp);
		radComp.click();
		scrollTo(0, 0);
		waitForElement(compPge);
		String cnfMsg = "You added product Radiant Tee to the comparison list.";
		Assert.assertEquals(radConf.getText(), cnfMsg);
		lst.log("Radiant Tee confirmation message confirmed");
		lst.takeScreenshot(driver);
	}

	public void breatheEz() {
		scrollTo(0, 1700);
		lst.takeScreenshot(driver);
		waitForElement(ezT);
		hover(ezT);
		lst.takeScreenshot(driver);
		waitForElement(ezTComp);
		ezTComp.click();
		scrollTo(0, 0);
		waitForElement(compPge);
		String cnfMsg = "You added product Breathe-Easy Tank to the comparison list.";
		Assert.assertEquals(ezConf.getText(), cnfMsg);
		lst.log("Breathe-Easy Tank confirmation message confirmed.");
		lst.takeScreenshot(driver);

	}

	public String verifyRT() {

		return rad.getText();
	}

	public String verifyEZT() {

		return ezT.getText();
	}
	
	public void argusTank() {
		scrollTo(0,1650);
		lst.takeScreenshot(driver);
		waitForElement(argus);
		hover(argus);
		lst.takeScreenshot(driver);
		waitForElement(argusComp);
		argusComp.click();
		waitForElement(compPge);
		String msg = "You added product Argus All-Weather Tank to the comparison list.";
		Assert.assertEquals(argusConf.getText(), msg);
		lst.log("Argus All-Weather Tank confirmation message confirmed");
		lst.takeScreenshot(driver);
	}
	
	public String verifyArgus() {
		return argus.getText();
		
	}
	

}
