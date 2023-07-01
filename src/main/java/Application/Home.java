package Application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.Generic;

public class Home extends Generic{
	WebDriver driver;
	
	public Home (WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//h2[normalize-space()='Hot Sellers']")
	WebElement hs;
	
	@FindBy(xpath="//a[normalize-space()='Radiant Tee']")
	WebElement rad;
	
	@FindBy(xpath="//li[1]//div[1]//div[1]//div[4]//div[1]//div[2]//a[2]")
	WebElement radComp;
	
	// You added product Radiant Tee to the comparison list.
	@FindBy(xpath="//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	WebElement radConf;
	
	@FindBy(xpath="//a[@title='Compare Products']")
	WebElement compPge;
	
	@FindBy(xpath="//a[normalize-space()='Radiant Tee']")
	WebElement compRad;
	
	public void radiantTee() {
		scrollTo(0,1600);
		hover(rad);
		waitForElement(radComp);
		radComp.click();
		scrollTo(0,0);
		waitForElement(compPge);
	}
	
	public String verifyRT() {
		
		return rad.getText();
	}

}
