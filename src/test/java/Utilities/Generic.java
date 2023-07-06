package Utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Generic {
	WebDriver driver;
	
	public Generic (WebDriver driver) {
		super();
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	public void scrollTo(int x, int y) {
		Actions a = new Actions(driver);
		a.scrollByAmount(x, y).build().perform();

	}
	
	public void scrollElement(WebElement element) {
		Actions a = new Actions(driver);
		a.scrollToElement(element).build().perform();

	}
	
	
	public void hover(WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).build().perform();
	}
	
	public void hover2(WebElement element, int x, int y) {
		Actions a = new Actions(driver);
		a.moveToElement(element, x, y);
	}
	
	public void click(WebElement element) {
		Actions a = new Actions(driver);
		a.click().build().perform();
	}
	
	public void waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForClick(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(90));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	

}
