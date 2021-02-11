package com.learning.testcases.others;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.learning.base.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_MultipleWindows extends TestBase {

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		preSetup(driver);

		driver.get("https://accounts.google.com/signup?hl=en");

		System.out.println("Title : " + driver.getTitle());
		driver.findElement(By.xpath("//a[contains(text(),'Help')]")).click();

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterate = windows.iterator();

		iterate.next();
		String second_window = iterate.next();

		driver.switchTo().window(second_window);

		holdScript(3);
		System.out.println("Title : " + driver.getTitle());
		driver.findElement(By.linkText("Community")).click();
		holdScript(3);
		System.out.println("Title : " + driver.getTitle());
		holdScript(3);
		System.out.println(message_success);
		// driver.close();
		driver.quit();
	}

}
