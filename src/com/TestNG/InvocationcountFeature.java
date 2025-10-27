package com.TestNG;

import org.testng.annotations.Test;

public class InvocationcountFeature {
	
	@Test(invocationCount = 10)
	public void sum() {
		
		int a=10;
		int b=30;
		int c= a+b;
		System.out.println("sum of c====="+ c);
	}

}
/* invocationcount is used any testcase multiples times using invocation keyword based on the requirement*/