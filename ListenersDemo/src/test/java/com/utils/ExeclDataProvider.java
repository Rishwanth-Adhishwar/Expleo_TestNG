package com.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExeclDataProvider {
	
	
	@DataProvider(name="vdatas")
	public static Object[][] validDatas() throws IOException
	{
		return exceldataProvider("tutnv");
	}
	
	@DataProvider(name="ivdatas",parallel=true)
	public static Object[][] inValidDatas() throws IOException
	{
		return exceldataProvider("tutniv");
	}
	
	public static Object[][] exceldataProvider(String sheet) throws IOException
	{
		String path="D:\\Selinium_Automation\\ListenersDemo\\src\\test\\resources\\tnTestData.xlsx";
		return exceldataReader(path,sheet);
	}
	public static Object[][] exceldataReader(String file,String Sheet) throws IOException
	{
		Object[][] data=null;
		
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet(Sheet);
		int noOfRows=sheet.getPhysicalNumberOfRows();
		int noOfCells=sheet.getRow(0).getLastCellNum();
		
		data=new Object[noOfRows-1][noOfCells];
		
		DataFormatter format=new DataFormatter();
		for(int i=1;i<noOfRows;i++)
		{
			XSSFRow row=sheet.getRow(i);
			for(int j=0;j<noOfCells;j++)
			{
				XSSFCell cell=row.getCell(j);
				data[i-1][j]=format.formatCellValue(cell);
			}
		}
		
		wb.close();
		fis.close();
		return data;
	}
 
	
}
