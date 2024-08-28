package com.TestNGDemo;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class D13CreateLoginInfo_Excel {

    File file;
    FileOutputStream fos ;
    XSSFWorkbook wb;
    XSSFSheet sheet;
    XSSFRow row;
    XSSFCell cell;
    int index = 1;

    @BeforeTest
    public void configure() throws FileNotFoundException {
        file = new File("MyThirdExcel.xlsx"); // if not specified path it will store in project folder
        fos = new FileOutputStream(file);
        wb = new XSSFWorkbook();
        sheet = wb.createSheet("FirstSheet"); // will create this named sheet inside workbook (wb)

        sheet.createRow(0).createCell(0).setCellValue("Username");
        sheet.getRow(0).createCell(1).setCellValue("Pasword");
        sheet.getRow(0).createCell(2).setCellValue("Result");
    }

    @Test(dataProvider = "getLoginData")
    public void enterCredentials(String un, String ps, String Res)
    {

        row = sheet.createRow(index);
        cell = row.createCell(0);
        cell.setCellValue(un);

        cell = row.createCell(1);
        cell.setCellValue(ps);

        cell = row.createCell(2);
        cell.setCellValue(Res);

        index = index + 1;
    }

    @DataProvider
    public Object[][]getLoginData()
    {
        String[][] loginData = new String[][]
                {
                        {"admin", "admin123", "Not Run"},
                        {"Vaishali", "vg123", "Not Run"},
                        {"monu", "monu123", "Not Run"},
                        {"admin", "admin123", "Not Run"},
                        {"sarvesh","sarvesh123", "Not Run"},
                };
        return loginData;
    }

    @AfterTest
    public void tearDown() throws IOException {
        wb.write(fos); // write data to excelsheet
        wb.close();
        fos.close();
    }

}
