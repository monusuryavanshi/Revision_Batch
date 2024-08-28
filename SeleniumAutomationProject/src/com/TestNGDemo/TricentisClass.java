package com.TestNGDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.time.Duration;

public class TricentisClass {
    static WebDriver driver;

    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //.... to complete
        TricentisClass t1 = new TricentisClass();
        t1.clickAutomobile();
        t1.selectMake("");
        // .. complete
    }

    public void clickAutomobile()
    {
        driver.findElement(By.partialLinkText("")).click(); // click on automobile option
        // select make drop down list
    }

    public void selectMake(String make)
    {
        /*Select vMake = new Select(driver.findElement(By.id("")));
        vMake.selectByVisibleText(make);*/
        // OR below line
        new Select(driver.findElement(By.id("make"))).selectByVisibleText(make);

    }

    public void setEnginePerformance(String enginePerformance)
    {
        driver.findElement(By.id("")).sendKeys(enginePerformance);
    }

    public void setDateofManufacture(String dt)
    {
        driver.findElement(By.id("")).sendKeys(dt);
    }

    public void setEnginePerformance1(String enginePerformance)
    {
        driver.findElement(By.id("")).sendKeys(enginePerformance);
    }
}
