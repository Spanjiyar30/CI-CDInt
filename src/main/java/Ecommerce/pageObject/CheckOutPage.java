package Ecommerce.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Ecommmere.AbstractComponent.Class1;

public class CheckOutPage extends Class1{

	WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css ="input[placeholder='Select Country']")
	 WebElement textBox;
	@FindBy(xpath ="//section/button[2]")
	 WebElement selectCountry;
	By countrylist =By.cssSelector(".ta-results");
	@FindBy(css ="a[class*='btnn']")
	 WebElement submit;
	
	public void countryToselect(String country) {
		Actions a =new Actions(driver);
		a.sendKeys(textBox,country).build().perform();
		waitElementsToAppear(countrylist);
		selectCountry.click();
	}
	
	public void submitOrder() throws InterruptedException {
		JavascriptExecutor j = (JavascriptExecutor)driver;
		j.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(5000);
		
		submit.click();
	}
}
