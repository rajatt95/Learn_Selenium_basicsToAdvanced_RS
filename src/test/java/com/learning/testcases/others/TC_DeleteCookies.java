package com.learning.testcases.others;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.learning.base.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_DeleteCookies extends TestBase {

	public static void main(String[] args) {

		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		preSetup(driver);

		driver.manage().deleteCookieNamed("cookie-jetBlue");
		driver.manage().deleteAllCookies();

		driver.get("https://www.google.com/");

		holdScript(3);

		System.out.println(message_success);
		driver.quit();
	}

}
