package com.TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//Execution sequence

/*@BeforeMethod
 * @Test (Testcase-1)
 * @AfterMethod*/

//Groups annotation in TestNG is nothing but it will group the testcases for a particular feature using "groups" keyword

/*To get HTML reports  we need to do is we have to refresh the project and test-output folder will be created and then
you can see index.html file over there copy the path and open in any browser.*/

public class GoogleTest {
	
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
	
	@Test(priority=1,groups="Title")
	public void GoogleTitleTest() {
		String title= driver.getTitle();
		System.out.println(title);
	}
	
	@Test(priority=2,groups="logo")
	public void GoogleLogoTest() {
		String logo = driver.findElement(By.xpath("//img[@class='lnXdpd']")).getText();
		System.out.println(logo);
	}
	
	@Test(priority=3,groups="maillink")
	
	public void MaillinkTest()
	{
		boolean link = driver.findElement(By.xpath("//a[@aria-label='Gmail (opens a new tab)']")).isDisplayed();
		System.out.println(link);
	}
	
	@AfterMethod
	public void Teardown() {
		driver.quit();
	}

}
