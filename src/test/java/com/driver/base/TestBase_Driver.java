package com.driver.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestBase_Driver {

	public final String searchBox_Name = "q";
	public final String searchBox_textToEnter = "Full Stack Test Automation Engineer";

	public final String url = "https://www.google.com/";
	public final int implicitWait = 10;

	public final String message_success = "Success";

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

	public void testCase(WebDriver driver) {
		driver.get(url);
		driver.manage().window().maximize();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);

		WebElement searchBox = driver.findElement(By.name(searchBox_Name));
		searchBox.sendKeys(searchBox_textToEnter);
		searchBox.sendKeys(Keys.ENTER);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Current URL: " + driver.getCurrentUrl());
		System.out.println("Current Title: " + driver.getTitle());
		// System.out.println("Page source: " + driver.getPageSource());
		System.out.println(message_success);
		driver.quit();

	}

}
