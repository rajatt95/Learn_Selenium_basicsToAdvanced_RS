package com.learning.testcases.greenKart;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.learning.base.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_GreenKart extends TestBase {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		preSetup(driver);

		driver.get("https://rahulshettyacademy.com/seleniumPractise/");

		ArrayList<String> listOfItems = getListOfItems();

		selectItem(driver, listOfItems);

		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

		driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("promoBtn")).click();

		System.out.println("Code Applied : "
				+ driver.findElement(By.xpath("//span[contains(text(),'Code applied ..!')]")).getText());

		System.out.println(message_success);
		driver.quit();
	}

	private static ArrayList<String> getListOfItems() {
		ArrayList<String> listOfItems = new ArrayList<String>();
		listOfItems.add("Cucumber");
		listOfItems.add("Brocolli");
		listOfItems.add("Beetroot");
		listOfItems.add("Cauliflower");
		return listOfItems;
	}

	private static void selectItem(WebDriver driver, ArrayList<String> listOfItems) {
		// h4[text()='Cucumber - 1Kg']
		for (String item : listOfItems) {
			WebElement btn_addToCart = driver
					.findElement(By.xpath("//h4[contains(text(),'" + item + "')]/following-sibling::div/button"));
			btn_addToCart.click();
			holdScript(1);
		}

	}
}
