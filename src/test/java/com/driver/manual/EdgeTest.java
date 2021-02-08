package com.driver.manual;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.driver.base.TestBase_Driver;

public class EdgeTest extends TestBase_Driver {

	public static void main(String[] args) {
		System.setProperty(edgeDriver, edgeDriverPath);
		WebDriver driver = new EdgeDriver();
		new TestBase_Driver().testCase(driver);
	}
}
