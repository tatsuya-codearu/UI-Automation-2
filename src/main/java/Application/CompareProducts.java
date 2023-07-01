package Application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utilities.Generic;

public class CompareProducts extends Generic{
	WebDriver driver;
	Home home;
	
	public CompareProducts(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.home = new Home(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void comp1() {
		home.radiantTee();
		//scrollTo(home.radConf);
		home.compPge.click();
		//scrollTo(home.compRad);
		Assert.assertEquals(home.verifyRT(), home.compRad.getText());
		
	}

}
