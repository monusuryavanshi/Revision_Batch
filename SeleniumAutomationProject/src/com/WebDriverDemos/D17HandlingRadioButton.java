package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D17HandlingRadioButton {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://register.rediff.com/register/register.php?FormName=user_details");

        WebElement genRadioBtn = driver.findElement(By.cssSelector("input[value='f']"));
        System.out.println("Before...");
        System.out.println("Radiobutton Selected Status :"+ genRadioBtn.isSelected());
        System.out.println("Radiobutton Enabled Status :"+ genRadioBtn.isEnabled());
        System.out.println("Radiobutton Displayed Status :"+ genRadioBtn.isDisplayed());
        if (!genRadioBtn.isSelected())
            genRadioBtn.click();
        System.out.println("\nAfter...");
        System.out.println("Radiobutton Selected Status :"+ genRadioBtn.isSelected());
        System.out.println("Radiobutton Enabled Status :"+ genRadioBtn.isEnabled());
        System.out.println("Radiobutton Displayed Status :"+ genRadioBtn.isDisplayed());

        driver.close();
   }
}
