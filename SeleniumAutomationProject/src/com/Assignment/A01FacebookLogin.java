package com.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A01FacebookLogin {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");

        WebElement userName = driver.findElement(By.className("inputtext")); //class="inputtext _55r1 _6luy"
        userName.sendKeys("monu31.5@gmail.com");

        WebElement userPass = driver.findElement(By.className("_9npi"));
        userPass.sendKeys("12345678");

        WebElement userLogin = driver.findElement(By.className("_42ft")); // as id is dynamic, changing so used name again
        userLogin.click();

        WebElement errorMsg = driver.findElement(By.cssSelector("div[class=\"_9ay7\"]"));
        System.out.println("Error Message : " +errorMsg.getText());

        driver.close();
    }
}
