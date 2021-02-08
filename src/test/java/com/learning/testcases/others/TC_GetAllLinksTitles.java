package com.learning.testcases.others;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import com.learning.base.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_GetAllLinksTitles extends TestBase {

	public static void main(String[] args) {

		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		preSetup(driver);

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		getFooter_1stColumn_Links_Title_Details(driver);

		System.out.println(message_success);
		driver.quit();
	}

	private static void getFooter_1stColumn_Links_Title_Details(WebDriver driver) {

		WebElement footer_1stColumn = driver.findElement(By.xpath("//tbody/tr/td[1]/ul[1]"));
		List<WebElement> listOfAnchorTagsIn_1stColumn_Footer = footer_1stColumn.findElements(By.tagName("a"));
		int linksCount = listOfAnchorTagsIn_1stColumn_Footer.size();
		System.out.println("Links count : " + linksCount);

		openLinksInNewTab(listOfAnchorTagsIn_1stColumn_Footer, linksCount);

		getTitleFromAllTabs(driver);

	}

	private static void getTitleFromAllTabs(WebDriver driver) {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterate = windows.iterator();

		while (iterate.hasNext()) {
			driver.switchTo().window(iterate.next());
			System.out.println("Title : " + driver.getTitle());
		}
	}

	private static void openLinksInNewTab(List<WebElement> listOfAnchorTagsIn_1stColumn_Footer, int linksCount) {
		for (int link = 1; link < linksCount; link++) {
			String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			listOfAnchorTagsIn_1stColumn_Footer.get(link).sendKeys(clickOnLinkTab);
			// holdScript(1);
		}
	}

}
