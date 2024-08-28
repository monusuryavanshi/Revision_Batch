package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D13LocateByXPath_Relative {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//form[@class='_9vtf']/div/div/input")).sendKeys("monu31.5@gmail.com");
        driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("123456789");
        driver.findElement(By.xpath("//button[contains(text(),\"Log in\")]")).submit(); //check this again
        // or we can use //button[contains(text(),'Log in')]
        // or we can use //button[text() = "Log in"]
        // or //button[@name='login']
        System.out.println(driver.findElement(By.xpath("//div[@class=\"_9ay7\"]")).getText());
        // or
        driver.close();
    }
}
