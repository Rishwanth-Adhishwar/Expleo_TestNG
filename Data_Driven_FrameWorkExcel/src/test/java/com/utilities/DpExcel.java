package com.utilities;

import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.testng.annotations.DataProvider;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class DpExcel {
	@DataProvider(name = "vData", parallel = true)
	public static Object[][] validData() throws IOException
	{
		Object[][] arrObj=DpExcel.excelDataProvider();
		return new Object[][]{
			arrObj[0]
		};
	}
	
	@DataProvider(name = "iData", parallel = true)
	public static Object[][] invalidData() throws IOException
	{
		Object[][] arrObj=DpExcel.excelDataProvider();
		return new Object[][]{
			arrObj[1],
			arrObj[2]
		};
	}


	public static Object[][] excelDataProvider() throws IOException {
		Object[][] arrObj = getExcelData(
				"D:\\Selinium_Automation\\Data_Driven_FrameWorkExcel\\src\\test\\resources\\TestData.xlsx", "sheet1");

		return arrObj;
	}

	private static Object[][] getExcelData(String file, String sheetName) throws IOException {
		// TODO Auto-generated method stub
		String[][] data = null;

		try {
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook work = new XSSFWorkbook(fis);

			XSSFSheet sheet = work.getSheet(sheetName);

			XSSFRow row = sheet.getRow(0);

			int noOfRows = sheet.getPhysicalNumberOfRows();

			int noOfCols = row.getLastCellNum();

			Cell cell;

			data = new String[noOfRows - 1][noOfCols];

			for (int i = 1; i < noOfRows; i++) {
				for (int j = 0; j < noOfCols; j++) {
					row = sheet.getRow(i);
					cell = row.getCell(j);

					data[i - 1][j] = cell.getStringCellValue();

//					System.out.println(data[i-1][j]+ " ");

				}
			}
		}

		catch (Exception e) {
			System.out.println("The exception is : " + e.getMessage());
		}

		return data;

	}

}
