package com.test;

import org.testng.annotations.Test;

//(dependsonMethods) feature is one of the important feature in TestNG annotations bcz some testcases are completely dependent on other testcases 
/*ex: TC-1 "Loginpage" and TC-2 "Registration page" so in this two test cases if login page is not working some times then there is no point 
 * to execute the Reg testcase i.e whatever the dependent test cases are there in the script related to "Loginpage" those were skipped if Loginpage test case is failed
 * that is the biggest advantage of dependency feature
 */

public class Dependencyfeature {
	@Test
	public void Loginpage() {

		System.out.println("Login to the application");
	}

	@Test(dependsOnMethods = "Loginpage")
	public void Regpage() {
		System.out.println("Register");
	}

	@Test(dependsOnMethods = "Loginpage")
	public void Searchpage() {
		System.out.println("Search for products");
	}

}
