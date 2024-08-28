package com.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A02EchoTrack {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.echotrak.com/Login.aspx?ReturnUrl=%2f");
        WebElement userName = driver.findElement(By.cssSelector("input[placeholder=\"Username\"]"));
        userName.sendKeys("TestUser");
        WebElement userPass = driver.findElement(By.cssSelector("input[placeholder=\"Password\"]"));
        userPass.sendKeys("123456789");
        WebElement userLogin = driver.findElement(By.cssSelector("input[class=\"btn btn-lg btn-block btn-primary\"]"));
        userLogin.click();
        System.out.println(driver.findElement(By.cssSelector("span[class=\"error\"]")).getText());
        driver.close();
    }
}
