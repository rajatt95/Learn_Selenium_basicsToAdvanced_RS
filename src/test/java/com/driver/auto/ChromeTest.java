package com.driver.auto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.driver.base.TestBase_Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeTest extends TestBase_Driver {
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		new TestBase_Driver().testCase(driver);
	}
}
