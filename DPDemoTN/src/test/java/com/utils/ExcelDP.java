package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.testng.annotations.DataProvider;

public class ExcelDP {

    @DataProvider(name = "vData", parallel = true)
    public static Object[][] validData() throws IOException {
        return excelDataProvider("vsheet");
    }

    @DataProvider(name = "iData", parallel = true)
    public static Object[][] invalidData() throws IOException {
        return excelDataProvider("ivsheet");
    }

    public static Object[][] excelDataProvider(String sheetName) throws IOException {
        String path = "C:\\Users\\krish\\git\\testng\\DPDemoTN\\src\\test\\resources\\tutorialsDemoTestDatas.xlsx";
        return getExcelData(path, sheetName);
    }

    private static Object[][] getExcelData(String file, String sheetName) throws IOException {
        Object[][] data = null;
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook work = new XSSFWorkbook(fis);
        XSSFSheet sheet = work.getSheet(sheetName);
        int noOfRows = sheet.getPhysicalNumberOfRows();
        int noOfCols = sheet.getRow(0).getLastCellNum();
        data = new Object[noOfRows - 1][noOfCols];
        DataFormatter formatter = new DataFormatter();
        for (int i = 1; i < noOfRows; i++) {
            XSSFRow row = sheet.getRow(i);
            for (int j = 0; j < noOfCols;		 j++) {
                Cell cell = row.getCell(j);
                data[i - 1][j] = formatter.formatCellValue(cell);
            }
        }
        work.close();
        fis.close();
        return data;
    }
}