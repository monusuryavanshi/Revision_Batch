package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D09LocateByCssSelectorSpecialCharacters {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");

        //#    // used only for ID attribute --> #email
        //.    // used only for Class attribute --> ._9npi
        //input[class='inputtext _55r1 _6luy']
        WebElement userName = driver.findElement(By.cssSelector("#email")); // input[placeholder="Email address or phone number"]
        userName.sendKeys("monu31.5@gmail.com");

        //input[class$='_9npi']
        // or WebElement userPass = driver.findElement((By.cssSelector("#passContainer"))); // input[placeholder="Password"]
        WebElement userPass = driver.findElement(By.cssSelector("input[class$=\"9npi\"]")); //$ special character that ends with fixed value
        userPass.sendKeys("12345678");

        //button[class="_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy"]
        WebElement userLogin = driver.findElement(By.cssSelector("button[id^=\"u_0_9\"]")); //^ special character to start with fixed value
        userLogin.click();

        WebElement errorMsg = driver.findElement(By.cssSelector("div[class=\"_9ay7\"]"));
        System.out.println("Error Message : " +errorMsg.getText());

        //driver.close();
    }
}
