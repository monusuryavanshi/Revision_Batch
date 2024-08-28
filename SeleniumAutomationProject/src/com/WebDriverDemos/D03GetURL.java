package com.WebDriverDemos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class D03GetURL {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.OrangeHRM.com");
        String URL = driver.getCurrentUrl();
        System.out.println("URL is : "+ URL);
        driver.close();
    }
}
