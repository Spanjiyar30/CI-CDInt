package Ecommerce.pageObject;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ecommmere.AbstractComponent.Class1;

public class productCatalog extends Class1{

	WebDriver driver;
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	By product =By.cssSelector(".mb-3");
	By addTocart=By.xpath("//button[text()=' Add To Cart']");
	By toast=By.cssSelector(".toast-message");
	@FindBy(css="la-ball-scale-multiple")
	WebElement spinner;

	
	public productCatalog(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
  public List<WebElement> getProductList() {
	 // waitElementsToAppear(product);
	  System.out.println("producyt list displayed");
	  return products;
  }
  
  public WebElement getProductName(String product ) {
	  
	  
	  List<WebElement> gpl= getProductList();
	  System.out.println("web Elmnt extracted");
	 return gpl.stream().filter(s->s.findElement(By.cssSelector("b")).getText().equals(product)).collect(Collectors.toList()).get(0);
	 
	 
  }
  
  public void addProduct(String product) {
	 getProductName(product).findElement(addTocart).click();
	 System.out.println("adding to cart");
	 waitElementsToAppear(toast);
	 waitElementsToDisappear(spinner);
  }
}
