package datgadriven.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Parametarization {

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
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/angularpractice/");
	}

	@Test
	public void Formfilling() {
		
		/* established Excel sheet connection using xls reader class */
		XLSReader reader = new XLSReader(
				"C:\\Users\\Reddybabu\\eclipse-workspace\\TestNGandDatadrivenlearningbynaveen\\src\\com\\testdata\\From.xlsx");
		int rowcount = reader.getRowCount("RegTestData"); // getRowCount method will give the total no of rows which are
															// present in the excel sheet
		
		reader.addColumn("RegTestData", "Status");

		for (int rowNum = 2; rowNum <= rowcount; rowNum++) {
			String name = reader.getCellData("RegTestData", "Name", rowNum);
			System.out.println(name);

			String emailid = reader.getCellData("RegTestData", "Email", rowNum);
			System.out.println(emailid);

			String pswd = reader.getCellData("RegTestData", "Password", rowNum);
			System.out.println(pswd);

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
			
			reader.setCellData("RegTestData", "Status", rowNum, "Pass"); // write the data in t a cell

		}
	}

//	@AfterMethod 
//	public void Teardown() { 
//		 driver.quit();
//		 
//	 }

}
