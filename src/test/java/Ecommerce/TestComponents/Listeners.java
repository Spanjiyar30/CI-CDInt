package Ecommerce.TestComponents;

import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Ecommerce.resources.TestRports;

public class Listeners implements ITestListener {
	TestRports tr= new TestRports();
	ExtentReports report =tr.extentReport();
	ExtentTest reportResult;

	@Override
	public void onTestStart(ITestResult result) {
		reportResult=report.createTest(result.getMethod().getMethodName());
	}
	public void onTestSuccess(ITestResult result) {
		reportResult.log(Status.PASS, "tEST pASSED");
	}
	public void onTestFailure(ITestResult result) {
		reportResult.fail(result.getThrowable());
	}
	

}
