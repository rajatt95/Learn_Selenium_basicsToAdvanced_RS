package com.learning.testcases.others;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import com.learning.base.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_Calendar extends TestBase {

	private static final String seeMoreResults_XPath = "//a[normalize-space()='See more requests']";

	public static void main(String[] args) {

		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		preSetup(driver);

		driver.get("https://www.path2usa.com/");

		// scrollToElement(true, seeMoreResults_XPath, driver);

		// 3 times - Page Down
		for (int i = 1; i <= 3; i++) {
			driver.switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
			holdScript(1);
		}
		driver.findElement(By.xpath(seeMoreResults_XPath)).click();

		selectDate(driver);
		holdScript(3);
		System.out.println(message_success);
		driver.quit();
	}

	private static void selectDate(WebDriver driver) {
		driver.findElement(By.id("travel_date")).click();

		String month = "June";
		String day = "27";

		selectMonth(driver, month);
		selectDay(driver, day);

	}

	private static void selectMonth(WebDriver driver, String month) {
		while (!driver.findElement(By.cssSelector("table[class=' table-condensed'] th[class='datepicker-switch']"))
				.getText().contains(month)) {
			driver.findElement(By.cssSelector("table[class=' table-condensed'] th[class='next']")).click();
		}
	}

	private static void selectDay(WebDriver driver, String day) {
		List<WebElement> dates = driver.findElements(By.className("day"));
		int dateCount = dates.size();
		System.out.println("Total dates : " + dateCount);
		for (int i = 0; i < dateCount; i++) {
			String text = driver.findElements(By.className("day")).get(i).getText();
			if (text.equalsIgnoreCase(day)) {
				driver.findElements(By.className("day")).get(i).click();
				break;
			}
		}
	}

}
