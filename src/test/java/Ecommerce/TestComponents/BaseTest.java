package Ecommerce.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Ecommerce.pageObject.landingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public landingPage lp;

	public WebDriver intializeDriver() throws IOException {
		
	Properties p =new Properties();
	FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Ecommerce\\resources\\Globalproperty.properties");
	p.load(file);
	String browserName=System.getProperty("browser")!=null ? System.getProperty("browser"):p.getProperty("browser");
//	String browserName=p.getProperty("browser");
	if(browserName.contains("chrome")) {
	    ChromeOptions option =new ChromeOptions();
	    if(browserName.contains("headless")) {
	    option.addArguments("headless");}
	    
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver(option);
	    driver.manage().window().maximize();
		//System.out.println("Login success");
	}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	
	return driver;
}
	@BeforeTest(alwaysRun=true)
	public landingPage launchApp() throws IOException {
	    lp =new landingPage(intializeDriver());
	    lp.goTo();
	    return lp;
		
	}
	@AfterTest(alwaysRun=true)
	public void close() {
		driver.close();
	}
	
	public List<HashMap<String,String>> getJsonData(String filepath) throws IOException {
		String jsonContent=FileUtils.readFileToString(new File(filepath),StandardCharsets.UTF_8);
		ObjectMapper mp =new ObjectMapper();
		List<HashMap<String,String>> l=mp.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){});
		return l;
	}


}