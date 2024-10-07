package Ecommerce.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ecommmere.AbstractComponent.Class1;

public class landingPage extends Class1 {

	WebDriver driver;
	
	public landingPage(WebDriver driver2) {
		super(driver2);
		this.driver=driver2;
		PageFactory.initElements(driver2,this);
	}

	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(css="input[type='password']")
	WebElement pass;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement submitButton;
	@FindBy(className="toast-error")
	WebElement Error;
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	public void login(String Email, String Password) {
		
		userEmail.sendKeys(Email);
		pass.sendKeys(Password);
		submitButton.click();
	}
	
	public String getErrorMsg() {
		waitElementsToAppear(Error);
		return Error.getText();
	}
}

   
   


