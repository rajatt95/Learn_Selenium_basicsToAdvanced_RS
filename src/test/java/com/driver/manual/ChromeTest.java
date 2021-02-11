package com.driver.manual;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.driver.base.TestBase_Driver;

public class ChromeTest extends TestBase_Driver {

	public static void main(String[] args) {

		System.setProperty(chromeDriver, chromeDriverPath);
		WebDriver driver = new ChromeDriver();
		new TestBase_Driver().testCase(driver);
	}
}
