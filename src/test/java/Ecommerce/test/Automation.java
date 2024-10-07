package Ecommerce.test;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Ecommerce.TestComponents.BaseTest;
import Ecommerce.pageObject.CheckOutPage;
import Ecommerce.pageObject.cartPage;
import Ecommerce.pageObject.landingPage;
import Ecommerce.pageObject.productCatalog;
import Ecommmere.AbstractComponent.Class1;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Automation extends BaseTest {

	@Test(dataProvider="getData",groups= {"MultipleLogin"})
	public void mainPage(HashMap<String,String> cred) throws InterruptedException, IOException {
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		String product = "ZARA COAT 3";
		String country= "Indi";
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://rahulshettyacademy.com/client");
		//driver.manage().window().maximize();
		//launchApp();
		System.out.println(cred.get("email"));
		lp.login(cred.get("email"), cred.get("password"));
		productCatalog clss =new productCatalog(driver);
		//landingPage lp = new landingPage(driver);
		Class1 abs =new Class1(driver);
		//lp.login();
		clss.addProduct(product);
		abs.goToCart();
		cartPage cp =new cartPage(driver);
		//Assert.assertTrue(cp.cartItems(product));
		cp.checkoutPage();
		CheckOutPage cop = new CheckOutPage(driver);
		cop.countryToselect(country);
		cop.submitOrder();
		
		
		
		
		//driver.findElement(By.id("userEmail")).sendKeys("kumar.guddu.ghy@gmail.com");
		//driver.findElement(By.cssSelector("input[type='password']")).sendKeys("P@ssw0rd");
	   // driver.findElement(By.xpath("//input[@type='submit']")).click();
	    
	//   List<WebElement> productsWebElement = driver.findElements(By.className("mb-3")); 
	  // Thread.sleep(5000);
	   
	 // List<WebElement> filteredProduct= productsWebElement.stream().filter(s->s.findElement(By.cssSelector("b")).getText().equals(product)).collect(Collectors.toList());
	
	// productsWebElement.stream().filter(s->s.getText().contains("ZARA COAT 3")).forEach(p->System.out.println(p.findElements(By.xpath("//button[text()='Add To Cart']"))));
	// filteredProduct.get(0).findElement(By.xpath("//button[text()=' Add To Cart']")).click();
	// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-message")));
	 
	// wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".la-ball-scale-multiple"))));
	 
	// driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();
	//// List<WebElement> selectedProduct= driver.findElements(By.cssSelector("cartSection h3"));
	//Boolean match= selectedProduct.stream().anyMatch(s->s.getText().equalsIgnoreCase(product));
	
	//driver.findElement(By.xpath("/html/body/app-root/app-profile/div/div[2]/ul/li/div/div[3]/button[1]")).click();
	//Actions a =new Actions(driver);
//	a.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")),"Indi").build().perform();
//	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
////	driver.findElement(By.xpath("//section/button[2]")).click();
	//Thread.sleep(5000);
	//JavascriptExecutor j = (JavascriptExecutor)driver;
	//j.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	//Thread.sleep(5000);
	
	//driver.findElement(By.cssSelector("a[class*='btnn']")).click();
		}
	
	@Test(dependsOnMethods= {"mainPage"})
	public void ordrConfirmation() {	
		
		System.out.println("Order Confirmed");
		
	}
	@DataProvider
	public Object[][] getData() throws IOException {
		//return new Object[][] {{"kumar.guddu.ghy@gmail.com","P@ssw0rd"}, {"dipalisanjaychavan@gmail.com","1234Dipali@"} };
		List<HashMap<String,String>> l=getJsonData((System.getProperty("user.dir")+"\\src\\test\\java\\Ecommerce\\data\\dataReader.json"));
		//System.out.println(l.get(1));
	//	System.out.println(l.get(0));
		return new Object[][] {{l.get(0)}, {l.get(1)}};
	}

}
