package com.learning.testcases.others;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import com.learning.base.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_Tables_NotWorking extends TestBase {

	public static void main(String[] args) {

		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		preSetup(driver);

		driver.get(
				"https://www.cricbuzz.com/live-cricket-scorecard/32253/ind-vs-eng-1st-test-england-tour-of-india-2021");

		WebElement table = driver.findElement(
				By.xpath("//div[@class='cb-col cb-col-67 cb-scrd-lft-col html-refresh ng-isolate-scope']"));

		List<WebElement> listOFElementsInTable = table.findElements(By.xpath(
				"//body/div[@class='page']/div[@id='page-wrapper']/div[@class='cb-col cb-col-100 cb-bg-white']/div[@class='cb-col cb-col-67 cb-scrd-lft-col html-refresh ng-isolate-scope xh-highlight']/div[@id='innings_1']/div[4]/div[3]"));

		System.out.println(listOFElementsInTable.size());

		for (WebElement element : listOFElementsInTable) {

			System.out.println(element);
			System.out.println(element.getText());
		}

		holdScript(3);

		System.out.println(message_success);
		driver.quit();
	}

}
