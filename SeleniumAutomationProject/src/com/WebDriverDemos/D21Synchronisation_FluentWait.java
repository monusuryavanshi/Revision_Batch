package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class D21Synchronisation_FluentWait {
    public static void main(String[] args) {

        ChromeOptions op = new ChromeOptions();
        op.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(op);
        driver.manage().window().maximize();

        driver.get("https://www.redbus.in/");

        //Fluent Wait
        FluentWait<WebDriver>wait = new FluentWait<>(driver);

        //Source
        driver.findElement(By.id("src")).sendKeys("Kolh");
        wait.withTimeout(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class)
                .pollingEvery(Duration.ofMillis(1))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"autoSuggestContainer\"]/div/div/div[1]/div/div[1]/ul/li[1]/div/text"))).click();

        //Target
        driver.findElement(By.id("dest")).sendKeys("Pun");
        wait.withTimeout(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class)
                .pollingEvery(Duration.ofMillis(1))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"autoSuggestContainer\"]/div/div/div[3]/div[1]/ul/li[1]/div/text"))).click();

        //Calender
        driver.findElement(By.xpath("//*[@id=\"onwardCal\"]/div/i")).click();
        driver.findElement(By.xpath("//span[text()=\"31\"]")).click();

        //Search Bus
        driver.findElement(By.id("search_button")).click();

        //Bus Name


        System.out.println(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"15974011\"]/div/div[1]/div[1]/div[1]/div[1]"))).getText());
        //System.out.println(driver.findElement(By.xpath("//*[@id=\"15974011\"]/div/div[1]/div[1]/div[1]/div[1]")).getText());

        driver.close();
    }
}
