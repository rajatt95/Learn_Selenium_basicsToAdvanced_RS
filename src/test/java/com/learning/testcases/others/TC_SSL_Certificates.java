package com.learning.testcases.others;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.learning.base.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_SSL_Certificates extends TestBase {

	public static void main(String[] args) {

		WebDriver driver = setCapabilityForChromeBrowser();

		driver.get("https://www.amazon.com/");

		holdScript(3);
		System.out.println(message_success);
		driver.quit();
	}

	private static WebDriver setCapabilityForChromeBrowser() {
		// General Chrome profile
		DesiredCapabilities ch = DesiredCapabilities.chrome();
//		ch.acceptInsecureCerts();

		ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		// Belows to local browser
		ChromeOptions c = new ChromeOptions();
		c.merge(ch);

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(c);
		preSetup(driver);
		return driver;
	}

}
