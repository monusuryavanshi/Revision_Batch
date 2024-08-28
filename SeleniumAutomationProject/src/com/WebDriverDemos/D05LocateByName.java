package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D05LocateByName {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");

        WebElement emailId = driver.findElement(By.name("email"));
        emailId.sendKeys("monu31.5@gmail.com");

        WebElement pass = driver.findElement(By.name("pass"));
        pass.sendKeys("12345678");

        WebElement login = driver.findElement(By.name("login"));
        login.click();

    }
}
