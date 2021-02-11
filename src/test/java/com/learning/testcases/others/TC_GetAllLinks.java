package com.learning.testcases.others;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import com.learning.base.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_GetAllLinks extends TestBase {

	public static void main(String[] args) {

		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		preSetup(driver);

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		getTotalLinksDetails(driver);
		System.out.println("=======================================================");
		getFooterLinksDetails(driver);
		System.out.println("=======================================================");
		getFooter_1stColumn_LinksDetails(driver);

		System.out.println(message_success);
		driver.quit();
	}

	private static void getFooter_1stColumn_LinksDetails(WebDriver driver) {
		WebElement footer_1stColumn = driver.findElement(By.xpath("//tbody/tr/td[1]/ul[1]"));
		List<WebElement> listOfAnchorTagsIn_1stColumn_Footer = footer_1stColumn.findElements(By.tagName("a"));
		System.out.println("Links count : " + listOfAnchorTagsIn_1stColumn_Footer.size());
		for (WebElement link : listOfAnchorTagsIn_1stColumn_Footer) {
			System.out.println(link.getAttribute("href"));
		}
	}

	private static void getFooterLinksDetails(WebDriver driver) {

		WebElement footer = driver.findElement(By.id("gf-BIG"));
		List<WebElement> listOfAnchorTagsInFooter = footer.findElements(By.tagName("a"));
		System.out.println("Links count : " + listOfAnchorTagsInFooter.size());
		for (WebElement link : listOfAnchorTagsInFooter) {
			System.out.println(link.getAttribute("href"));
		}
	}

	private static void getTotalLinksDetails(WebDriver driver) {
		List<WebElement> listOfAnchorTags = driver.findElements(By.tagName("a"));
		System.out.println("Links count : " + listOfAnchorTags.size());
		for (WebElement link : listOfAnchorTags) {
			System.out.println(link.getAttribute("href"));
		}
	}

}
