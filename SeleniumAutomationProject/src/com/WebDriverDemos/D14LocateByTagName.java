package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class D14LocateByTagName {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
       List<WebElement>Links = driver.findElements(By.tagName("a"));
        System.out.println("Total Link : "+Links.size());
        System.out.println(Links.get(0).getText());
        for (int i=0; i <Links.size(); i++)
            System.out.println(Links.get(i).getText());
        // or can use below for
        for (WebElement l : Links)
            System.out.println(l.getText());
        driver.close();
    }
}
