package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class D27NavigateMethods {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://www.google.co.in/"); // ability to remember its history
        // driver.get() : has implicitly wait of 30 secs to get page loaded completely

        driver.findElement(By.linkText("Gmail")).click();
        System.out.println(driver.getWindowHandles());

        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();
        Thread.sleep(2000);
        driver.close();
    }
}
