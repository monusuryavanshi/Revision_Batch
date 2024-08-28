package com.TestNGDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class D02MultipleTests {


    @Test (priority = 0)
    public void openGoogle()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://www.Google.com");

        System.out.println(driver.getTitle());
        driver.close();
    }

    @Test (priority = 2)
    public void openMyntra()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.myntra.com/");

        System.out.println(driver.getTitle());
        driver.close();
    }

    @Test (priority = 1)
    public void openAmazon()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.in/");

        System.out.println(driver.getTitle());
        driver.close();
    }
}
