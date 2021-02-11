package com.learning.testcases.autoIT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import com.learning.base.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_WIN_Auth_PopUp_UsingSelenium extends TestBase {

	public static void main(String[] args) {

		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		preSetup(driver);

		String username = "admin";
		String password = "admin";
		String URL = "https://" + username + ":" + password + "@" + "the-internet.herokuapp.com/";
		/*
		 * driver.get("https://the-internet.herokuapp.com/");
		 */

		System.out.println("URL : " + URL);
		driver.get(URL);
		driver.findElement(By.linkText("Basic Auth")).click();

		WebElement congratsMessage = driver
				.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credenti')]"));
		System.out.println("Congratulations message status: " + congratsMessage.isDisplayed());

		System.out.println("Congratulations message text: " + congratsMessage.getText());

		holdScript(3);

		System.out.println(message_success);
		driver.quit();
	}

}