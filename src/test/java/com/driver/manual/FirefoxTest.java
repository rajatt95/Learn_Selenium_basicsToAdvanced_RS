package com.driver.manual;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.driver.base.TestBase_Driver;

public class FirefoxTest extends TestBase_Driver {

	public static void main(String[] args) {
		System.setProperty(firefoxDriver, firefoxDriverPath);
		WebDriver driver = new FirefoxDriver();
		new TestBase_Driver().testCase(driver);
	}
}
