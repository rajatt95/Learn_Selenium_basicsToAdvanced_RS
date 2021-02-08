package com.driver.auto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.driver.base.TestBase_Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EdgeTest extends TestBase_Driver {
	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		new TestBase_Driver().testCase(driver);
	}
}
