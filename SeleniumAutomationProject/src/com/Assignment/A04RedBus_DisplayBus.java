package com.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class A04RedBus_DisplayBus {
    public static void main(String[] args) throws InterruptedException {
        //Disable notification
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.redbus.in/");

        //driver.findElement(By.xpath("//div[@class=\"icon icon-cross crossIcon\"]")).click();

        WebElement fromPlace = driver.findElement(By.cssSelector("input[id=\"src\"]"));
        fromPlace.sendKeys("Kolh");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id=\"autoSuggestContainer\"]/div/div/div[1]/div/div/ul/li[1]/div/text")).click();

        WebElement toPlace = driver.findElement(By.cssSelector("input[id=\"dest\"]"));
        toPlace.sendKeys("Pune");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id=\"autoSuggestContainer\"]/div/div/div[3]/div/ul/li[1]/div/text")).click();

        WebElement dt = driver.findElement(By.xpath("//div[@id=\"onwardCal\"]/div/div"));
        dt.click();
        driver.findElement(By.xpath("//span[normalize-space()='31']")).click();
        Thread.sleep(2000);

        WebElement bSearch = driver.findElement(By.cssSelector("button[id=\"search_button\"]"));
        bSearch.click();
        Thread.sleep(5000);

        ////*[@id=\"15974011\"]/div/div[1]/div[1]/div[1]/div[1]
        System.out.println(driver.findElement(By.xpath("/html/body/section/div[2]/div[4]/div/div[2]/div/div[2]/div[2]/div/ul/div[1]/li/div/div[1]/div[1]/div[1]/div[1]")).getText());
        //System.out.println(driver.findElement(By.xpath("//*[@id=\"15974011\"]/div/div[1]/div[1]/div[1]/div[1]")).getText());

        driver.close();

        /*/////Refresh Browser using below :
        driver.get(driver.getCurrentUrl());
        driver.findElement(By.name("s")).sendKeys(Keys.F5);
        driver.navigate().refresh();
        driver.navigate().to(driver.getCurrentUrl());*/



    }
}
