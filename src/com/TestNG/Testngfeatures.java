package com.TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testngfeatures {
	//annotations that are started with @before those are called "pre-conditions"
	//Using TestNg features we can write test cases in the form of 3 diff sections with help of diff annotations
	//1,pre-condition section 2.Testcases section 3.post-condition section  
	//The execution of each and every annotation is diff
	
//Output:	
	/*  @BeforeSuite---set up system proprities for chrome >>I
@BeforeTest----launchBrowser >>II
@BeforeClass---login the app >>III

@BeforeMethod----enter Url   
@Test----Google Title Test             >> Testcase-1
@AfterMethod----logout from app

@BeforeMethod----enter Url
@Test---search for google title        >> Testcase-2
@AfterMethod----logout from app

@AfterClass----close browser
@AfterTest-----deleteCoockies */
	
	// The pair will be created like this after execution of every test case
	/*@BeforeMethod
	 * @Test (Testcase-1)
	 * @AfterMethod
	 
	 * *@BeforeMethod
	 * @Test (Testcase-2)
	 * @AfterMethod
	 * 
	 * *@BeforeMethod
	 * @Test (Testcase-3)
	 * @AfterMethod
	 */

	
	@BeforeSuite // executed 1st
	public void setUp() {
		System.out.println("@BeforeSuite---set up system proprities for chrome");
	}
	
	@BeforeClass //execueted 3rd
	public void login() {
		System.out.println("@BeforeClass---login the app");
	}
	@BeforeTest // executes 2nd
	public void launchtheBrowse() {
		System.out.println("@BeforeTest----launchBrowser");
		
	}
	@BeforeMethod //execuetd 4th
	public void enterUrl() {
		System.out.println("@BeforeMethod----enter Url");
	}
	
	//Test cases starting with @Test annotation
	@Test //execuetd 5th
	public void googleTitleTest() {
		System.out.println("@Test----Google Title Test");
	}
	@Test
	public void search() {
		System.out.println("@Test---search for google title");
	}
	
	
	//post-conditions starting with @After annotation
	@AfterMethod  //executed 6th
	public void logOut()
	{
		System.out.println("@AfterMethod----logout from app");
	}
	
	@AfterClass  //execuetd 7th
	public void closeBrowser() {
		System.out.println("@AfterClass----close browser");
	}
	@AfterTest // execuetd 8th
	public void deleteAllCoockies() {
		System.out.println("@AfterTest-----deleteCoockies");
	}
	
	@AfterSuite //exuted 9th
	public void generateReports() {
		System.out.println("@AfterSuite---generate test reports");
	}

}
