package com.WebDriverDemos;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class D24HandlingAlert {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true); // ssl certificate 
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/alerts");

        Alert alt ; // use Alert api methods to handle alerts/popups (if popups are not having inspect element then it is alert)

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 200)", ""); // page is scrolled down

        //Click Button to see alert
        js.executeScript("arguments[0].click()", driver.findElement(By.id("alertButton")));
        alt = driver.switchTo().alert();
        System.out.println(alt.getText());
        alt.accept();

        //On button click, alert will appear after 5 seconds
        driver.findElement(By.cssSelector("button[id=\"timerAlertButton\"]")).click();
        Thread.sleep(5000);
        alt = driver.switchTo().alert();
        System.out.println(alt.getText());
        alt.accept();

        //On button click, confirm box will appear
        driver.findElement(By.id("confirmButton")).click();
        alt = driver.switchTo().alert();
        System.out.println(alt.getText());
        alt.accept();
        Thread.sleep(5000);
        System.out.println(driver.findElement(By.id("confirmResult")).getText());

        //On button click, prompt box will appear
        driver.findElement(By.id("promtButton")).click();
        alt = driver.switchTo().alert();
        System.out.println(alt.getText());
        alt.sendKeys("Hello");
        Thread.sleep(2000);
        alt.accept();
        System.out.println(driver.findElement(By.id("promptResult")).getText());

        Thread.sleep(5000);
        //driver.close();
    }
}
