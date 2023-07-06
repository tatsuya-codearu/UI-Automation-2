package Application;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Reporting.listeners;
import Utilities.ExcelData;
import Utilities.Generic;

public class checkout extends Generic {
	WebDriver driver;
	

	public checkout(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="firstname")
	WebElement fname;

	@FindBy(name = "lastname")
	WebElement lname;

	@FindBy(name = "street[0]")
	WebElement str;

	@FindBy(name = "city")
	WebElement city;

	@FindBy(name = "region")
	WebElement province;

	@FindBy(name = "postcode")
	WebElement zip;

	@FindBy(name = "country_id")
	WebElement country;

	@FindBy(name = "telephone")
	WebElement number;

	@FindBy(name = "ko_unique_2")
	WebElement delivery;

	@FindBy(xpath = "//option[@value='ZA']")
	WebElement za;

	@FindBy(xpath = "//span[normalize-space()='Next']")
	WebElement next;
	
	@FindBy(xpath="//span[normalize-space()='Place Order']")
	WebElement order;
	
	@FindBy(xpath="//span[normalize-space()='New Address']")
	WebElement address;
	
	@FindBy(className="checkbox")
	WebElement save;
	
	@FindBy(xpath="//span[normalize-space()='Ship here']")
	WebElement ship;

	public void checkTest(String testid) throws IOException, InterruptedException {
		Cart cart = new Cart(driver);
		listeners lst = new listeners();
		ExcelData xl = new ExcelData();
		cart.chckout(testid);
		
		waitForClick(address);
		Thread.sleep(15000);
		address.click();
		
		waitForElement(fname);
		fname.clear();
		fname.sendKeys(xl.xlData(testid, "firstName"));

		waitForElement(lname);
		lname.clear();
		lname.sendKeys(xl.xlData(testid, "lastName"));

		waitForElement(str);
		str.clear();
		str.sendKeys(xl.xlData(testid, "street"));

		waitForElement(city);
		city.clear();
		city.sendKeys(xl.xlData(testid, "city"));

		lst.takeScreenshot(driver);

		scrollElement(country);
		Thread.sleep(5000);
		waitForClick(country);
		country.click();
		za.click();
		
		
		scrollTo(0,500);
		waitForClick(province);
		province.clear();
		province.sendKeys(xl.xlData(testid, "province"));

		waitForClick(zip);
		zip.clear();
		String code = xl.xlData(testid, "zip_code");
		String code2 = code.substring(0, 4);
		zip.sendKeys(code2);

		waitForClick(number);
		number.clear();
		number.sendKeys(xl.xlData(testid, "phone_no"));

		lst.takeScreenshot(driver);
		
		ship.click();

		Thread.sleep(5000);
		waitForClick(next);
		next.click();
		lst.takeScreenshot(driver);
		Thread.sleep(5000);
		order.click();
		Thread.sleep(15000);
		lst.takeScreenshot(driver);

	}
}
