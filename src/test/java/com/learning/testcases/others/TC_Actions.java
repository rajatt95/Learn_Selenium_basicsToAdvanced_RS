package com.learning.testcases.others;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import com.learning.base.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_Actions extends TestBase {

	public static void main(String[] args) {

		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		preSetup(driver);

		driver.get("https://www.amazon.com/");

		Actions actions = new Actions(driver);

		// Move to specific element
		WebElement helloSignIn = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
		actions.moveToElement(helloSignIn).perform();

		// Multiple actions and making it as Composite action
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		actions.click(searchBox).click().keyDown(Keys.SHIFT).sendKeys("inputsInSmallConvertingToCapsUsingActionsClass")
				.doubleClick().build().perform();
		actions.moveToElement(searchBox).contextClick().perform();
		// searchBox.sendKeys("FULL STACK TEST AUTOMATION ENGINEER using sendKeys()");

		holdScript(3);
		System.out.println(message_success);
		driver.quit();
	}

}
