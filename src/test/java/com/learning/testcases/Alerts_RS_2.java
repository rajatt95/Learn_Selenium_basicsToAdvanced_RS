package com.learning.testcases;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.learning.base.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts_RS_2 extends TestBase {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		preSetup(driver);

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		String profile = "Full Stack Test Automation Engineer";
		driver.findElement(By.id("name")).sendKeys(profile);
		driver.findElement(By.id("confirmbtn")).click();

		String alertText = driver.switchTo().alert().getText();

		System.out.println("Alert text : " + alertText);
		Assert.assertTrue(alertText.contains(profile));

		System.out.println("====Dismiss Alert======");
		driver.switchTo().alert().dismiss();

		System.out.println("====Accept Alert======");
		driver.findElement(By.id("confirmbtn")).click();
		driver.switchTo().alert().accept();

		System.out.println(message_success);
		driver.quit();

	}

}