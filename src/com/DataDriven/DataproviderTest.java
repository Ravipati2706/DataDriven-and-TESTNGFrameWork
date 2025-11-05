package com.DataDriven;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utilpackage.Utiltest;

public class DataproviderTest {

	WebDriver driver;

	@BeforeMethod
	public void Setup() {

		// System.setProperty("webdriver.chrome.driver",
		// "C:/Users/Reddybabu/OneDrive/Documents/SeleniumDrivers/chromedriver.exe");
//	ChromeOptions options = new ChromeOptions();
//	options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://rahulshettyacademy.com/angularpractice/");
	}

	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testdata = Utiltest.getDataFromExcel();
		return testdata.iterator();
	}

	@Test(dataProvider = "getTestData")
	public void ProtocommerceForm(String name, String emailid, String pswd) {

		driver.findElement(By.xpath("//input[@name='name']")).clear();
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(name);

		driver.findElement(By.xpath("//input[@name='email']")).clear();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(emailid);

		driver.findElement(By.cssSelector("input#exampleInputPassword1")).clear();
		driver.findElement(By.cssSelector("input#exampleInputPassword1")).sendKeys(pswd);

		Select dropdown = new Select(driver.findElement(By.cssSelector("select#exampleFormControlSelect1")));
		dropdown.selectByVisibleText("Male");

		driver.findElement(By.cssSelector("input[class='btn btn-success']")).click();

		String successmsg = driver.findElement(By.cssSelector("div[class='alert alert-success alert-dismissible']"))
				.getText();
		System.out.println(successmsg);
	}

	@AfterMethod
	public void Teardown() {
		driver.quit();

	}

}
