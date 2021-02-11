package com.learning.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.learning.base.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Count_CheckBoxes extends TestBase {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		preSetup(driver);

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		int checkBoxesCount = driver.findElements(By.xpath("//input[@type='checkbox']")).size();

		System.out.println("Total checkboxes : " + checkBoxesCount);
		holdScript(2);

		Assert.assertEquals(checkBoxesCount, 6);

		System.out.println(message_success);
		driver.quit();

	}

}