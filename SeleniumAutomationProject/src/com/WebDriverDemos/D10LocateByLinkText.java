package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D10LocateByLinkText {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        WebElement gmailLink = driver.findElement(By.linkText("Gmail"));
        gmailLink.click();
        String title = driver.getTitle();
        if(title.contains("Gmail"))
        System.out.println("Test case Passed");
        else
        System.out.println("Test case Failed");
        driver.close();
    }
}

