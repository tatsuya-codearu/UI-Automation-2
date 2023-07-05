package Application;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Reporting.listeners;
import Utilities.ExcelData;
import Utilities.Generic;

public class Tees extends Generic{
	WebDriver driver;
	//Logging lg = new Logging(driver);
	listeners lst = new listeners();
	ExcelData xl = new ExcelData();
	
	public Tees (WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="a[id='ui-id-5'] span:nth-child(2)")
	WebElement men;
	
	@FindBy(xpath="(//a[@id='ui-id-17'])[1]")
	WebElement tops;
	
	@FindBy(css="a[id='ui-id-21'] span")
	WebElement tee;
	
	@FindBy(xpath="//a[normalize-space()='Strike Endurance Tee']")
	WebElement strike;
	
	@FindBy(xpath="//li[1]//div[1]//div[1]//div[4]//div[1]//div[1]//form[1]//button[1]//span[1]")
	WebElement add;
	
	@FindBy(css="div[data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	WebElement opt;
	
	@FindBy(xpath="//a[@aria-label='store logo']//img")
	WebElement homepge;
	
	@FindBy(xpath="//input[@id='search']")
	WebElement search;
	
	@FindBy(xpath="//a[normalize-space()='Miko Pullover Hoodie']")
	WebElement miko;
	
	@FindBy(xpath="(//div[@id='option-label-size-143-item-168'])[1]")
	WebElement miko_size;
	
	@FindBy(css="body > div:nth-child(4) > main:nth-child(4) > div:nth-child(4) > div:nth-child(1) > div:nth-child(5) > div:nth-child(3) > ol:nth-child(1) > li:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2)")
	WebElement miko_color;
	
	@FindBy(css="body > div:nth-child(4) > main:nth-child(4) > div:nth-child(4) > div:nth-child(1) > div:nth-child(5) > div:nth-child(3) > ol:nth-child(1) > li:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(5) > div:nth-child(1) > div:nth-child(1) > form:nth-child(1) > button:nth-child(4) > span:nth-child(1)")
	WebElement miko_add;
	
	@FindBy(xpath="//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	WebElement miko_conf;
	
	@FindBy(css=".action.showcart")
	WebElement cart;
	
	@FindBy(xpath="//span[normalize-space()='View and Edit Cart']")
	WebElement view;
	
	
	public void test5(String testid) throws IOException, Exception {
		Logging lg = new Logging(driver);
		lg.login(testid);
		waitForElement(men);
		hover(men);
		waitForElement(tops);
		hover(tops);
		waitForElement(tee);
		//hover(tee);
		lst.takeScreenshot(driver);
		tee.click();;
		waitForElement(strike);
		hover(strike);
		lst.takeScreenshot(driver);
		Thread.sleep(2000);
		add.click();
		waitForElement(opt);
		String msg = "You need to choose options for your item.";
		//Assert.assertEquals(opt.getText(), msg);
		if(opt.getText().equals(msg)) {
			lst.log("Message to say select options in order to add to cart confirmed");
			lst.takeScreenshot(driver);
		}else {
			lst.log("No message found");
		}
	}

	public void test6(String testid)throws IOException{

		click(search);
		search.sendKeys(xl.xlData(testid, "product"));
		lst.takeScreenshot(driver);
		search.sendKeys(Keys.ENTER);
		
		waitForElement(miko);
		hover(miko);
		scrollTo(0,600);
		waitForElement(miko_size);
		miko_size.click();
		waitForElement(miko_color);
		miko_color.click();
		lst.takeScreenshot(driver);
		scrollElement(miko_add);
		waitForElement(miko_add);
		miko_add.click();
		scrollTo(0,0);
		waitForElement(miko_conf);
		String msg="You added Miko Pullover Hoodie to your shopping cart.";
		if(miko_conf.getText().equals(msg)) {
			lst.log("Miko Pullover Hoodie confirmation message confirmed");
		}else {
			lst.log("Confirmation message not found");
		}
		waitForElement(cart);
		cart.click();
		waitForElement(view);
		view.click();;
		
	}
}
