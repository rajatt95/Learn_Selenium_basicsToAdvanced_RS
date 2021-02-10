package com.learning.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import com.learning.base.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_Text_CAPS extends TestBase {

	public static void main(String[] args) {

		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		preSetup(driver);

		driver.get("https://www.google.com/");

		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys(Keys.SHIFT, "full stack Automation test engineer");
		searchBox.sendKeys(Keys.ENTER);
		
		holdScript(3);
		System.out.println(message_success);
		driver.quit();
	}

}
