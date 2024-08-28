package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D16HandlingCheckbox {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://register.rediff.com/register/register.php?FormName=user_details");

        WebElement chk = driver.findElement(By.cssSelector("input[name^=\"chk_altemail\"]"));
        System.out.println("Before...");
        System.out.println("Checkbox Selected Status :"+ chk.isSelected());
        System.out.println("Checkbox Enabled Status :"+ chk.isEnabled());
        System.out.println("Checkbox Displayed Status :"+ chk.isDisplayed());
        if (chk.isSelected()==false) // or is (!=chk.isSelected());
            chk.click();
        System.out.println("\nAfter...");
        System.out.println("Checkbox Selected Status :"+ chk.isSelected());
        System.out.println("Checkbox Enabled Status :"+ chk.isEnabled());
        System.out.println("Checkbox Displayed Status :"+ chk.isDisplayed());

        driver.close();
    }
}
