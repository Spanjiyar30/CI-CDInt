package Ecommerce.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ecommmere.AbstractComponent.Class1;

public class cartPage extends Class1{

	WebDriver driver;
	
	public cartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css ="cartSection h3")
	 List<WebElement> selectedProduct;
	@FindBy(xpath ="/html/body/app-root/app-profile/div/div[2]/ul/li/div/div[3]/button[1]")
	 WebElement checkOutButton;
	public Boolean cartItems(String product) {
		Boolean match= selectedProduct.stream().anyMatch(s->s.getText().equalsIgnoreCase(product));
		return match;
	}
	public void checkoutPage() {
		checkOutButton.click();
	}

}
