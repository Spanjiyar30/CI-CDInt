package Ecommerce.resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestRports {
	
	public  ExtentReports extentReport() {
		String path = System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter xs =new ExtentSparkReporter(path);
		xs.config().setReportName("Test Report");
		xs.config().setDocumentTitle("DEMO TEST");
		ExtentReports er = new ExtentReports();
		er.attachReporter(xs);
		er.setSystemInfo("Tester", "Santosh");
		return er;
		
	}
	
	

}
