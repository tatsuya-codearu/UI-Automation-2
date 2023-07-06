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

	@FindBy(linkText = "comparison list")
	WebElement compPge;

	@FindBy(xpath = "//a[normalize-space()='Radiant Tee']")
	WebElement compRad;

	@FindBy(xpath = "//a[normalize-space()='Breathe-Easy Tank']")
	WebElement ezT;

	@FindBy(xpath = "//li[2]//div[1]//div[1]//div[4]//div[1]//div[2]//a[2]")
	WebElement ezTComp;

	@FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	WebElement ezConf;

	@FindBy(xpath = "//a[normalize-space()='Breathe-Easy Tank']")
	WebElement compEZ;

	@FindBy(xpath = "//a[normalize-space()='Argus All-Weather Tank']")
	WebElement argus;

	@FindBy(xpath = "//li[3]//div[1]//div[1]//div[3]//div[1]//div[2]//a[2]")
	WebElement argusComp;

	@FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	WebElement argusConf;

	@FindBy(xpath = "//a[@title='Remove Product']")
	WebElement compRem;

	@FindBy(css = "a[title='Hero Hoodie']")
	WebElement hero;

	@FindBy(xpath = "(//div[@id='option-label-size-143-item-168'])[4]")
	WebElement hero_size;

	@FindBy(css = "#option-label-color-93-item-53")
	WebElement hero_color;

	@FindBy(xpath = "(//span[contains(text(),'Add to Cart')])[4]")
	WebElement hero_add;

	@FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	WebElement hero_conf;

	@FindBy(xpath = "//a[@class='action showcart']")
	WebElement cart;

	@FindBy(xpath = "//a[@data-bind='attr: {href: product_url}, html: product_name']")
	WebElement cart_hero;

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
		if (radConf.getText().equals(cnfMsg)) {
			lst.log("Radiant Tee confirmation message confirmed");
			lst.takeScreenshot(driver);
		} else {
			lst.log("Confirmation message not found");
		}

	}

	public void breatheEz() throws InterruptedException {
		scrollTo(0, 1700);
		lst.takeScreenshot(driver);
		waitForElement(ezT);
		hover(ezT);
		lst.takeScreenshot(driver);
		waitForElement(ezTComp);
		Thread.sleep(5000);
		ezTComp.click();
		scrollTo(0, 0);
		waitForElement(compPge);
		String cnfMsg = "You added product Breathe-Easy Tank to the comparison list.";
		if (ezConf.getText().equals(cnfMsg)) {
			lst.log("Breathe-Easy Tank confirmation message confirmed.");
		lst.takeScreenshot(driver);
		}else {
			lst.log("Confirmation message not found");
		}
		

	}

	public String verifyRT() {

		return rad.getText();
	}

	public String verifyEZT() {

		return ezT.getText();
	}

	public void argusTank() throws InterruptedException {
		scrollTo(0, 1650);
		lst.takeScreenshot(driver);
		waitForElement(argus);
		hover(argus);
		lst.takeScreenshot(driver);
		waitForElement(argusComp);
		Thread.sleep(5000);
		argusComp.click();
		waitForElement(compPge);
		String msg = "You added product Argus All-Weather Tank to the comparison list.";
		if (argusConf.getText().equals(msg)) {
			lst.log("Argus All-Weather Tank confirmation message confirmed");
			lst.takeScreenshot(driver);
		} else {
			lst.log("Confirmation message not found");
		}

	}

	public String verifyArgus() {
		return argus.getText();

	}

	public void hero() throws InterruptedException {
		scrollTo(0, 1650);
		lst.takeScreenshot(driver);
		waitForElement(hero);
		hover(hero);
		Thread.sleep(5000);
		hero_size.click();
		hero_color.click();
		lst.takeScreenshot(driver);
		hero_add.click();
		waitForElement(hero_conf);
		String msg = "You added Hero Hoodie to your shopping cart.";
		if (hero_conf.getText().equals(msg)) {
			lst.log("Confirmation message of Hero Hoodie added to cart confirmed");
		} else {
			lst.log("No confirmation message found");
		}
		lst.takeScreenshot(driver);
		cart.click();
		Thread.sleep(9000);
		if (cart_hero.getText().equals(hero.getText())) {
			lst.log("Hero Hoodie is added in cart when cart icon clicked");
		} else {
			lst.log("Hero Hoodie not found");
		}
		lst.takeScreenshot(driver);

	}

}
