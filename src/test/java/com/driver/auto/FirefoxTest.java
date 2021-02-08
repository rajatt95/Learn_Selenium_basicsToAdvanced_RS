package com.driver.auto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.driver.base.TestBase_Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxTest extends TestBase_Driver {
	public static void main(String[] args) {

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		new TestBase_Driver().testCase(driver);
	}
}
