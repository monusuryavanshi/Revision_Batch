package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class D19Synchronisation_ThreadSleep {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions op = new ChromeOptions();
        op.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(op);
        driver.manage().window().maximize();

        driver.get("https://www.redbus.in/");

        //Source
        driver.findElement(By.id("src")).sendKeys("Kolh");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"autoSuggestContainer\"]/div/div/div[1]/div/div[1]/ul/li[1]/div/text")).click();

        //Target
        driver.findElement(By.id("dest")).sendKeys("Pun");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"autoSuggestContainer\"]/div/div/div[3]/div[1]/ul/li[1]/div/text")).click();

        //Calender
        driver.findElement(By.xpath("//*[@id=\"onwardCal\"]/div/i")).click();
        //driver.findElement(By.xpath("//span[normalize-space()='31']")).click();
        driver.findElement(By.xpath("//span[text()=\"31\"]")).click();

        //Search Bus
        driver.findElement(By.id("search_button")).click();

        //Bus Name
        Thread.sleep(5000);
        System.out.println(driver.findElement(By.xpath("//*[@id=\"15974011\"]/div/div[1]/div[1]/div[1]/div[1]")).getText());

        driver.close();
    }
}
