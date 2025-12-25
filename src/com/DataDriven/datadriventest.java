package com.DataDriven;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class datadriventest {

	WebDriver driver;

	@BeforeMethod
	public void Setup() {

		// System.setProperty("webdriver.chrome.driver",
		// "C:/Users/Reddybabu/OneDrive/Documents/SeleniumDrivers/chromedriver.exe");//
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Test
	public void Formfilling() {
		// Webdriver code
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		/* established Excel sheet connection using xls reader class */
		ExcelReader reader = new ExcelReader(
				"C:\\Users\\bravindra\\git\\DataDriven-and-TESTNGFrameWork\\src\\com\\testdata\\From.xlsx");

		String name = reader.getCellData("RegTestData", "Name", 2);
		System.out.println(name);

		// getdata from excel
		String email = reader.getCellData("RegTestData", "Email", 2);
		System.out.println(email);

		String pswd = reader.getCellData("RegTestData", "Password", 2);
		System.out.println(pswd);

		// Webdriver code
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(name);

		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);

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
