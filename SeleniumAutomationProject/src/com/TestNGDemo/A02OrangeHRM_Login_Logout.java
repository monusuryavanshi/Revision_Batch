package com.TestNGDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class A02OrangeHRM_Login_Logout {
    WebDriver driver ;

    @BeforeTest
    public void openURL()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterTest
    public void closeBrowser()
    {
        driver.close();
    }
    @BeforeMethod
    public void openBrowser()
    {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    @AfterMethod
    public void loginLogout()
    {
        driver.findElement(By.cssSelector("button[type='submit']")).click(); // below
        //driver.findElement(By.xpath("//button[@type='submit']")).click();
        if (driver.getCurrentUrl().contains("dashboard"))
        {
            System.out.println(driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText()); // or //span/h6
            driver.findElement(By.xpath("//i[@class=\"oxd-icon bi-caret-down-fill oxd-userdropdown-icon\"]")).click();
            driver.findElement(By.xpath("//ul[@class=\"oxd-dropdown-menu\"]/li/a[text()=\"Logout\"]")).click();
        }
        else
        {
            System.out.println(driver.findElement(By.xpath("//p[text()=\"Invalid credentials\"]")).getText());
        }

    }
    @Test (priority = 1)
    public void enterInValidCredentials()
    {
        driver.findElement(By.name("username")).sendKeys("admin123");
        driver.findElement(By.name("password")).sendKeys("123456789");
    }
    @Test (priority = 0)
    public void enterValidCredentials()
    {
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
    }
    @Test (priority = 2)
    public void enterInValidCredentialsPass()
    {
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("123456789");
    }
}
