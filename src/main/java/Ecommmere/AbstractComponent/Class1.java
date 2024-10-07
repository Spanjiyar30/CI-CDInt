package Ecommmere.AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Class1 {

	WebDriver driver;
	public Class1(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="userEmail")
	WebElement userEmail;
	@FindBy(css="button[routerlink='/dashboard/cart']")
	WebElement cartButton;
	
	
	
	public void waitElementsToAppear(By locator) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		System.out.println("element is visible");
	}
	
	public void waitElementsToAppear(WebElement x) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(x));
		System.out.println("element is visible");
	}

	public void waitElementsToDisappear(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(ele));
		System.out.println("element is invisible");
	}
	 public void goToCart() {
		 cartButton.click();
	 }
}
