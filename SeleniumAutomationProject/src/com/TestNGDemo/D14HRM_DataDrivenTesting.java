package com.TestNGDemo;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class D14HRM_DataDrivenTesting {
    File file ;
    FileInputStream fis;
    XSSFWorkbook wb;
    XSSFSheet sheet;
    XSSFRow row;
    XSSFCell cell;


    @BeforeTest
    public void configure() throws IOException {
        file = new File("MyThirdExcel.xlsx"); // if specified file is not present in project then need to give complete path of file
        fis = new FileInputStream(file);
        wb = new XSSFWorkbook(fis);
        sheet = wb.getSheet("FirstSheet"); // name of excel's sheet

    }

    @DataProvider
    public Object[][] getLoginData()
    {
        int rows = sheet.getPhysicalNumberOfRows();
        String[][] loginData = new String[rows-1][2];
        for (int i = 0 ; i < rows-1 ; i++)
        {
            for (int j = 0 ; j <2 ; j++)
            {
                loginData[i][j] = sheet.getRow(i+1).getCell(j).getStringCellValue();
            }
        }
        return loginData;

    }

    @Test (dataProvider = "getLoginData")
    public void loginToHRM(String un, String ps)
    {

    }
}
