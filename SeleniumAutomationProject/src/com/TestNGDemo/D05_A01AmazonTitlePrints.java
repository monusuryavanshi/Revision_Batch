package com.TestNGDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class D05_A01AmazonTitlePrints {
    WebDriver driver ; // or Step 1

    @BeforeTest
    public void openBrowser()
    {
        driver = new ChromeDriver(); // or Step 2
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterTest
    public void closeBrowser()
    {
        driver.close();
        System.out.println("After Test");
    }
    @BeforeMethod
    public void beforeMethod()
    {
        System.out.println("Before Test");
        driver.get("https://www.amazon.in/");
        System.out.println("Title is : " + driver.getTitle());
    }
    @AfterMethod
    public void printTitle()
    {
        System.out.println("Title of clicked page is : " + driver.getTitle());
    }

    @Test (priority = 0)
    public void clickSellLink()
    {
        driver.findElement(By.partialLinkText("Sell")).click();
        System.out.println("Clicked on Sell Link");
    }
    @Test (priority = 1)
    public void clickBestSellerLink()
    {
        driver.findElement(By.partialLinkText("Best Sellers")).click();
        System.out.println("Clicked on Best Seller Link");
    }
    @Test (priority = 2)
    public void clickMobilesLink()
    {
        driver.findElement(By.partialLinkText("Mobiles")).click();
        System.out.println("Clicked on Mobiles Link");
    }
    @Test (priority = 3)
    public void clickElectroincsLink()
    {
        driver.findElement(By.partialLinkText("Electronics")).click();
        System.out.println("Clicked on Electronics Link");
    }
}
