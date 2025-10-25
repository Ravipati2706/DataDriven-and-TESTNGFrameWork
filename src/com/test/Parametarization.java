package com.test;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parametarization {

	WebDriver driver;

	@BeforeMethod
	@Parameters({ "env", "browser" })
	public void Setup(String env, String browser) {

		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:/Users/Reddybabu/OneDrive/Documents/SeleniumDrivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:/Users/Reddybabu/OneDrive/Documents/SeleniumDrivers/geckodriver.exe");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Test
	@Parameters({ "url", "emailid" })
	public void loginTest(String url, String emailid) {
		driver.get(url);
		driver.findElement(By.cssSelector("input[id='login-username']")).sendKeys(emailid);
		driver.findElement(By.cssSelector("input[id='login-signin']")).click();

	}
	
	@Test
	public void checksigninError() {
		boolean b = driver.findElement(By.xpath("//div[@class='writeup sml-txt description']")).isDisplayed();
		Assert.assertEquals(b, true);
	}

//	@AfterMethod
//	public void Teardown() {
//		driver.quit();
//
//	}
}
