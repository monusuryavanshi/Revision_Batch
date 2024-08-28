package com.TestNGDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class D03Before_After_Test {

    WebDriver driver = new ChromeDriver(); // declared globally or follow Step 1 and 2 instead of this 1 statement
    // WebDriver driver ; or Step 1

    @BeforeTest
    public void openBrowser()
    {
        // driver = new ChromeDriver(); // or Step 2
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Before Test");
    }
    @AfterTest
    public void closeBrowser()
    {
        driver.close();
        System.out.println("After Test");
    }
    @Test(priority = 0)
    public void openGoogle()
    {
        driver.get("http://www.Google.com");
        System.out.println(driver.getTitle());
    }

    @Test (priority = 2)
    public void openMyntra()
    {
        driver.get("https://www.myntra.com/");
        System.out.println(driver.getTitle());
    }

    @Test (priority = 1)
    public void openAmazon()
    {
        driver.get("https://www.amazon.in/");
        System.out.println(driver.getTitle());
    }
}
