package datgadriven.utility;

import org.testng.annotations.Test;

public class PoiExcelFeatures {
	
	@Test
	public void Exceloperations() {
		
		ExcelReader reader = new ExcelReader(
				"C:\\Users\\Reddybabu\\eclipse-workspace\\TestNGandDatadrivenlearningbynaveen\\src\\com\\testdata\\From.xlsx");
		
		//reader.addSheet("Homepage"); // 1st approach It will add new sheet in the workbook
		
		//2nd approach
		if(!reader.isSheetExist("Homepage")) {
			reader.addSheet("Homepage");
		}
		
		int colmCount = reader.getColumnCount("RegTestData");
		System.out.println("Total no of coloumns present in the sheet:====="+ colmCount);
		
		
	}

}
