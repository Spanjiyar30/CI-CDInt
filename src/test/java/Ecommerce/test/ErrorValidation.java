package Ecommerce.test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Ecommerce.TestComponents.BaseTest;
import Ecommerce.pageObject.landingPage;


public class ErrorValidation extends BaseTest {

	@Test(groups="ErrorH")
	public void LoginErrorValidation() throws IOException {
		String product = "ZARA COAT 3";
		landingPage landingPage = new landingPage(driver);
		landingPage.login("kumar.guddu.ghy@gmail.com", "P@sswd");
		//System.out.println(landingPage.getErrorMsg());
	   Assert.assertEquals("Incorrect email or password.",landingPage.getErrorMsg());
		
	}

}
