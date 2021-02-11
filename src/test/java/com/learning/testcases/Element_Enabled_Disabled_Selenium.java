package com.learning.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.learning.base.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Element_Enabled_Disabled_Selenium extends TestBase {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		preSetup(driver);

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		WebElement returnDate = driver.findElement(By.id("ctl00_mainContent_view_date2"));
		System.out.println("Return date - isEnabled() : " + returnDate.isEnabled());
		// Assert.assertFalse(returnDate.isEnabled());

		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		holdScript(2);
		WebElement returnDate_2 = driver.findElement(By.id("ctl00_mainContent_view_date2"));
		System.out.println("Return date - isEnabled() : " + returnDate_2.isEnabled());

		System.out.println(message_success);
		driver.quit();

	}

}