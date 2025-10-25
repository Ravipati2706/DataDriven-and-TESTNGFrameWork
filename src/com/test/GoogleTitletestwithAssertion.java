package com.test;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTitletestwithAssertion {
	WebDriver driver;

	@BeforeMethod
	public void Setup() {

		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Reddybabu/OneDrive/Documents/SeleniumDrivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.google.com");

	}

	@Test
	public void GoogleTitleTest() {
		String title = driver.getTitle();

		Assert.assertEquals(title, "Google", "title is not matched");

		/*
		 * Assertios are kind of validation in automation testing using these we can
		 * validate whether the expected outcome is correct or not
		 */

	}

	@Test
	public void GoogleLogoTest() {
		boolean b = driver.findElement(By.xpath("//img[@class='lnXdpd']")).isDisplayed();
		Assert.assertTrue(b);
		Assert.assertEquals(b, true);
	}

	@AfterMethod
	public void Teardown() {
		driver.quit();
	}

}
