package com.learning.testcases.extentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.learning.base.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_ExtentReports_Tutor extends TestBase {

	ExtentReports extent;

	@BeforeTest

	public void config() {
		// ExtentReports , ExtentSparkReporter
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Full Stack Automation Test Engineer", "Rajat Verma");
	}

	@Test
	public void initialDemo() {
		ExtentTest test = extent.createTest("Initial Demo");

		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		preSetup(driver);

		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		driver.close();
		// test.fail("Result do not match");
		extent.flush();

	}

}
