package com.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class A06DashBling {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notification");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://dash.bling-center.com/platform/signIn.html");

        driver.findElement(By.cssSelector("button[class=\"forget-password-btn\"]")).click();
        driver.findElement(By.cssSelector("input[id=\"email1\"]")).sendKeys("monu@gmail.com");
        driver.findElement(By.cssSelector("button[class=\"reset-pwd signIn-btn\"]")).click();
        Thread.sleep(2000);
        String msg =  driver.findElement(By.xpath("//p[@id='resetsuccess']")).getText();
        System.out.println(msg);

        driver.close();

    }
}
