package com.WebDriverDemos;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D08LocateByCssSelector {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");

        WebElement userName = driver.findElement(By.cssSelector("input[placeholder=\"Email address or phone number\"]")); //single
        userName.sendKeys("monu31.5@gmail.com");

        WebElement userPass = driver.findElement((By.cssSelector("input[type=\"password\"][placeholder=\"Password\"]")));
        userPass.sendKeys("12345678");

        WebElement userLogin = driver.findElement(By.cssSelector("button[class=\"_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy\"]"));
        userLogin.sendKeys(Keys.ENTER);
        // or this ==> userLogin.sendKeys(Keys.SPACE);

        WebElement errorMsg = driver.findElement(By.cssSelector("div[class=\"_9ay7\"]"));
        System.out.println("Error Message : " +errorMsg.getText());

        driver.close();
        //
    }
}
