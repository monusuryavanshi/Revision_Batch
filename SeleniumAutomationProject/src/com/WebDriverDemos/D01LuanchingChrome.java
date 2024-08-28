package com.WebDriverDemos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class D01LuanchingChrome {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriver driver1 = new FirefoxDriver();
        // webdriver is API
        // after selenium 4.7 selenium added something that will automatically download required driver of browser
        // sometimes session not created exception is thrown that means your web driver and your browser version are not same
        //
        driver.manage().window().maximize();
        //driver.get("www.Google.com"); // throws invalid exeption as selenium accepts absolute exception as sartrating from https
        driver.get("https://www.google.com");
        driver.close();

    }
}
