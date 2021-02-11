package com.learning.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.learning.base.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Element_Enabled_Disabled_CustomMethod extends TestBase {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		preSetup(driver);

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");


		getElementStatus(driver);

		System.out.println("==================");
		System.out.println("Clicking on Round Trip");
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();

		getElementStatus(driver);
		System.out.println(message_success);
		driver.quit();

	}

	private static void getElementStatus(WebDriver driver) {
		WebElement returnDate = driver.findElement(By.id("Div1"));
		System.out.println(returnDate.getAttribute("style"));
		if (returnDate.getAttribute("style").contains("0.5")) {
			System.out.println("Return date is disabled");
		} else if (returnDate.getAttribute("style").contains("1")) {
			System.out.println("Return date is enabled");
		}
	}

}