package com.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;
import java.time.Duration;

public class DemoQA_FindElement_Assignment {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/webtables");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String fname = "Swaroopa";

        driver.findElement(By.cssSelector("button[id=\"addNewRecordButton\"]")).click();
        driver.findElement(By.cssSelector("input[id=\"firstName\"]")).sendKeys(fname);
        driver.findElement(By.cssSelector("input[id=\"lastName\"]")).sendKeys("S");
        driver.findElement(By.cssSelector("input[id=\"userEmail\"]")).sendKeys("monu@gmail.com");
        driver.findElement(By.cssSelector("input[id=\"age\"]")).sendKeys("40");
        driver.findElement(By.cssSelector("input[id=\"salary\"]")).sendKeys("1000000");
        driver.findElement(By.cssSelector("input[id=\"department\"]")).sendKeys("QA");
        driver.findElement(By.cssSelector("button[id=\"submit\"]")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 400)", "");
        driver.findElement(RelativeLocator.with(By.xpath("//div[@class=\"rt-td\"]/div[@class=\"action-buttons\"]/span[@title=\"Delete\"]"))
                .toRightOf(By.xpath("//div[@class=\"rt-table\"]/div[2]/div[@class=\"rt-tr-group\"]/div/div[@class=\"rt-td\"][text()=\""+fname+"\"]"))).click();

        Thread.sleep(2000);

        driver.close();
    }
}
