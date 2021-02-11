package com.learning.base;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestBase {

	
	
	public final static String excel_Sheet = ".//src//test//resources//excel//testdata.xlsx";
	
	public final String searchBox_Name = "q";
	public final String searchBox_textToEnter = "Full Stack Test Automation Engineer";

	public final static String url = "https://www.google.com/";
	public final static int implicitWait = 10;

	public final static String message_success = "Success";

	// Manual
	public final static String chromeDriver = "webdriver.chrome.driver";
	public final static String chromeDriverPath = "F:\\Work_in_local_machine\\Softwares\\Drivers\\WIN\\chromedriver.exe";

	public final static String firefoxDriver = "webdriver.gecko.driver";
	public final static String firefoxDriverPath = "F:\\Work_in_local_machine\\Softwares\\Drivers\\WIN\\geckodriver.exe";

	public final static String edgeDriver = "webdriver.edge.driver";
	public final static String edgeDriverPath = "F:\\Work_in_local_machine\\Softwares\\Drivers\\WIN\\msedgedriver.exe";

	// MAC
	// public final static String chromeDriverPath =
	// "//Users//Rajat//Downloads//chromedriver";

	public static void preSetup(WebDriver driver) {
		driver.get(url);
		driver.manage().window().maximize();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);

	}

	public static void holdScript(int seconds) {
		try {
			Thread.sleep(1000 * seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/*
	 * True: Element - Up ,False: Element - Down
	 */
	public static void scrollToElement(Boolean flag, String webelementProperty, WebDriver driver) {

		WebElement element = driver.findElement(By.xpath(webelementProperty));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(" + flag + ");", element);
	}
}
