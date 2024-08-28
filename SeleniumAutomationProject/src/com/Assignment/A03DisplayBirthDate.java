package com.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.Select;

public class A03DisplayBirthDate {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://register.rediff.com/register/register.php?FormName=user_details");

        WebElement drpBDay = driver.findElement(By.cssSelector("select[name^=\"DOB_Day\"]"));
        Select dList = new Select(drpBDay);
        dList.selectByVisibleText("31");

        WebElement drpBMonth = driver.findElement(By.cssSelector("select[name^=\"DOB_Month\"]"));
        Select mList = new Select(drpBMonth);
        mList.selectByVisibleText("MAY");

        WebElement drpYear = driver.findElement(By.cssSelector("select[name^=\"DOB_Year\"]"));
        Select yList = new Select(drpYear);
        yList.selectByVisibleText("1945");

        String day, mon, year, dob;
        day = dList.getFirstSelectedOption().getText();
        mon = mList.getFirstSelectedOption().getText();
        year = yList.getFirstSelectedOption().getText();
        dob = day + "/" + mon + "/" + year ;
        System.out.println("My Birthdate is : "+ dob);

        driver.close();

    }
}
