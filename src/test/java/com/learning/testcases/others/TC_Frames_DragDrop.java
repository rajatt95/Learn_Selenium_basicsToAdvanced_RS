package com.learning.testcases.others;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.learning.base.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_Frames_DragDrop extends TestBase {

	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		preSetup(driver);

		driver.get("https://jqueryui.com/droppable/");
		holdScript(3);
		System.out.println("Title : " + driver.getTitle());
		listDownTheFramesCount(driver);

		switchToFrame_And_Do_DragAndDrop(driver);

		switchFocusToMainWindow(driver);

		holdScript(3);
		System.out.println(message_success);
		driver.quit();
	}

	private static void switchFocusToMainWindow(WebDriver driver) {
		// switch from frame to main page
		driver.switchTo().defaultContent();

		driver.findElement(By.xpath("//a[normalize-space()='Resizable']")).click();
		System.out.println("Title : " + driver.getTitle());
	}

	private static void switchToFrame_And_Do_DragAndDrop(WebDriver driver) {
		// iframeResult - ID of the Frame; we can ID/name/index

		// Using indexing
		// driver.switchTo().frame(0);

		// Using web element
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);

		WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement droppable = driver.findElement(By.id("droppable"));
		new Actions(driver).dragAndDrop(draggable, droppable).perform();

	}

	private static void listDownTheFramesCount(WebDriver driver) {
		// To get all the frames in the Page
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println("Total frames: " + frames.size());
		for (WebElement frame : frames) {
			System.out.println("ID of frame: " + frame.getAttribute("id"));
			System.out.println("Class of frame: " + frame.getAttribute("class"));
			System.out.println("-----------------");
		}
	}

}
