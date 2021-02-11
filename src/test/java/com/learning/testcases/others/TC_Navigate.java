package com.learning.testcases.others;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import com.learning.base.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;

/*navigate().back() – The above command requires no parameters and takes back the user to the previous webpage in the web browser’s history.

Sample code:
driver.navigate().back();

navigate().forward() – This command lets the user to navigate to the next web page with reference to the browser’s history.

Sample code:
driver.navigate().forward();

navigate().refresh() – This command lets the user to refresh the current web page there by reloading all the web elements.

Sample code:
driver.navigate().refresh();

navigate().to() – This command lets the user to launch a new web browser window and navigate to the specified URL.

Sample code:
driver.navigate().to(“https://google.com”);
*/
public class TC_Navigate extends TestBase {

	public static void main(String[] args) {

		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		preSetup(driver);

		driver.get("https://www.google.com/");
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Full Stack test Automation Engineer");
		searchBox.sendKeys(Keys.ENTER);

		holdScript(3);

		// driver.navigate().to("https://www.udemy.com/");
		driver.get("https://www.udemy.com/");
		holdScript(3);

		System.out.println(message_success);
		driver.quit();
	}

}
