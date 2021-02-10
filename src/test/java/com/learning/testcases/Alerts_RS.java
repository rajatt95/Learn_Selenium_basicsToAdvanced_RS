package com.learning.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.learning.base.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts_RS extends TestBase {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		preSetup(driver);

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		String profile = "Full Stack Test Automation Engineer";
		driver.findElement(By.id("name")).sendKeys(profile);
		driver.findElement(By.id("alertbtn")).click();

		String alertText = driver.switchTo().alert().getText();

		System.out.println("Alert text : " + alertText);
		Assert.assertTrue(alertText.contains(profile));
		driver.switchTo().alert().accept();

		/*
		 * // Other Way - Using Explicit wait WebDriverWait wait = new
		 * WebDriverWait(driver, 10); Alert alert =
		 * wait.until(ExpectedConditions.alertIsPresent());
		 * 
		 * holdScript(2); String alertText = alert.getText();
		 * System.out.println("Alert text: " + alertText);
		 * Assert.assertTrue(alertText.contains(profile)); alert.accept();
		 */
		System.out.println(message_success);
		driver.quit();

	}

}