package com.TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParametarization {

	protected WebDriver driver;

	@BeforeClass
	@Parameters({"browser"})
	public void Setup(String browser) {

		if (browser.equals("chrome")) {
//			System.setProperty("webdriver.chrome.driver",
//					"C:/Users/Reddybabu/OneDrive/Documents/SeleniumDrivers/chromedriver.exe");
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			
			driver = new FirefoxDriver();
			/*
			 * System.setProperty("webdriver.gecko.driver",
			 * "C:\\Users\\bravindra\\geckodriver-v0.36.0-win-aarch64.exe");
			 */
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Test(priority=1)
	@Parameters({ "url", "emailid", "pswd"})
	public void loginTest(String url, String emailid, String pswd) {
		driver.get(url);
		driver.findElement(By.cssSelector("input[id='login_field']")).clear();
		driver.findElement(By.cssSelector("input[id='login_field']")).sendKeys(emailid);
		driver.findElement(By.cssSelector("input[id='password']")).clear();
		driver.findElement(By.cssSelector("input[id='password']")).sendKeys(pswd);
		driver.findElement(By.cssSelector("[name='commit']")).click();

	}
	
	@Test(priority=2)
	public void ValidateLogo() {
//		boolean Dashboard = driver.findElement(By.xpath("//a[@aria-label='Homepage']")).isDisplayed();
//		Assert.assertEquals(Dashboard, true);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='copilot-chat-header-button']")));
		button.click();
		
//		WebElement chat = driver.findElement(By.xpath("//a[@id='copilot-chat-header-button']"));
//		chat.click();
	}

	@AfterClass
	public void Teardown() {
		driver.quit();

	}
}
