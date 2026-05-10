package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelDataProviderDM {
	@DataProvider(name="valid",parallel=true)
	public static Object[][] validDatas() throws IOException
	{
		return excelDataProvider("validDatas");
	}
	
	@DataProvider(name="invalid",parallel=true)
	public static Object[][] invalidDatas() throws IOException
	{
		return excelDataProvider("invlaidDatas");
	}
	
	public static Object[][] excelDataProvider(String sheet) throws IOException
	{
		String path="D:\\Selinium_Automation\\DemoBlazeTesting\\src\\test\\resources\\DemoBlazeTD.xlsx";
		return excelDataReader(path,sheet);
	}
	
	public static Object[][] excelDataReader(String path,String sheet) throws IOException
	{
		Object[][] data=null;
		FileInputStream fis=new FileInputStream(path);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheets=wb.getSheet(sheet);
		int totRows=sheets.getPhysicalNumberOfRows();
		int totCells=sheets.getRow(0).getLastCellNum();
		
		data=new Object[totRows-1][totCells];
		
		DataFormatter format=new DataFormatter();
		for(int i=1;i<totRows;i++)
		{
			XSSFRow row=sheets.getRow(i);
			for(int j=0;j<totCells;j++)
			{
				XSSFCell cell=row.getCell(j);
				data[i-1][j]=format.formatCellValue(cell);
			}
		}
		
		return data;
		
		
	}

}
