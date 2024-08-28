package com.TestNGDemo;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.*;

public class D13ReadFromExcel {
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
        sheet = wb.getSheet("FirstSheet"); // name of excel's sheet's sheet name

    }

    @Test
    public void readData()
    {
        /*
        row = sheet.getRow(0);
        cell = row.getCell(0);
        System.out.println(cell.getStringCellValue());

        cell = row.getCell(1);
        System.out.println(cell.getStringCellValue());

        cell = row.getCell(2);
        System.out.println(cell.getStringCellValue());

        System.out.println(sheet.getRow(1).getCell(0).getStringCellValue());
        System.out.println(sheet.getRow(1).getCell(1).getStringCellValue());
        System.out.println(sheet.getRow(1).getCell(2).getStringCellValue());
        */

        // Or below approach

        /*for (int i = 0 ; i < 5 ; i ++)
        {
            row = sheet.getRow(i);
            for (int j = 0 ; j < 3 ; j ++)
            {
                cell = row.getCell(j);
                System.out.println(cell.getStringCellValue()+ "\t");
            }
            System.out.println();
        }*/

        // Or below approach

        int rowsCount = sheet.getPhysicalNumberOfRows();
        int cellCount ;

        for (int i = 0 ; i < rowsCount ; i ++)
        {
            cellCount  = sheet.getRow(i).getPhysicalNumberOfCells();
            for (int j = 0 ; j < cellCount ; j ++)
            {
                System.out.println(sheet.getRow(i).getCell(j).getStringCellValue()+ "\t");
            }
            System.out.println();
        }
    }

    @AfterTest
    public void tearDown() throws IOException {
        wb.close();
        fis.close();
    }

}
