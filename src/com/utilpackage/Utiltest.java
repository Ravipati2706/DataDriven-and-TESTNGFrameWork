package com.utilpackage;

import java.util.ArrayList;

import datgadriven.utility.ExcelReader;

public class Utiltest {

	static ExcelReader reader;

	public static ArrayList<Object[]> getDataFromExcel() {
		
		ArrayList<Object[]> mydata = new ArrayList<Object[]>();
		try {
			reader= new ExcelReader("C:\\Users\\Reddybabu\\eclipse-workspace\\TestNGandDatadrivenlearningbynaveen\\src\\com\\testdata\\From.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(int rowNum=2; rowNum<=reader.getRowCount("RegTestData"); rowNum++) {
			
			String name = reader.getCellData("RegTestData", "Name", rowNum);
			
			String emailid = reader.getCellData("RegTestData", "Email", rowNum);
			
			String pswd = reader.getCellData("RegTestData", "Password", rowNum);
			
			Object ob[] = {name, emailid, pswd};
			mydata.add(ob);
			
			}
		
return mydata;
		
	}

}
