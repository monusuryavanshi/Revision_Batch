package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class D15Locator_RelativeLocator {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");
        driver.findElement(RelativeLocator.with(By.tagName("input")).above(By.name("pass"))).sendKeys("monu31.5@gmail.com");
                //above,  below, toleftof , torightof ==> selenium 4 provided those Relativelocators
        driver.findElement(RelativeLocator.with(By.tagName("input")).below(By.name("email"))).sendKeys("1234567890");
        driver.findElement(RelativeLocator.with(By.tagName("button")).below(By.name("pass"))).submit();
        System.out.println(driver.findElement(RelativeLocator.with(By.xpath("//div[@class=\"_9ay7\"]")).below(By.name("pass"))).getText());
        driver.close();
    }
}
