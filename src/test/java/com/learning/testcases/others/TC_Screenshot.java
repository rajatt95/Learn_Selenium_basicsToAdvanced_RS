package com.learning.testcases.others;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import com.learning.base.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_Screenshot extends TestBase {

	public static void main(String[] args) {

		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		preSetup(driver);

		driver.get("https://www.amazon.com/");

		captureElementScreenshot(driver.findElement(By.xpath("//h2[normalize-space()='Computers & Accessories']")),
				driver);

		captureScreenshotOfVisibleScreen(driver);

		holdScript(3);
		System.out.println(message_success);
		driver.quit();
	}

	private static void captureScreenshotOfVisibleScreen(WebDriver driver) {
		System.out.println("..............Full Page image...............");
		Date date = new Date();
		String fileName = date.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		System.out.println("Screenshot name: " + fileName);
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// Copying the taken screenshot to specified path - Root folder - .//
		try {
			FileUtils.copyFile(screenshot, new File(".//screenshot/" + fileName));
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private static void captureElementScreenshot(WebElement element, WebDriver driver) {
		System.out.println("..............Element image...............");
		Date date = new Date();
		String fileName = date.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		System.out.println("Element Screenshot name: " + fileName);
		File screenshot = element.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(screenshot, new File(".//screenshot/" + "Element_" + fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
