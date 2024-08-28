package com.Assignment;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A05CheckBoxes {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://echoecho.com/htmlforms09.htm");

        // Milk
        WebElement chkMilk = driver.findElement(By.cssSelector("input[type=\"checkbox\"][value=\"Milk\"]"));
        System.out.println("Milk Checkbox Status is Selected :" + chkMilk.isSelected());
        System.out.println("Milk Checkbox Status is Enabled :" + chkMilk.isEnabled());
        System.out.println("Milk Checkbox Status is Displayed :" + chkMilk.isDisplayed());
        if (chkMilk.isSelected()){
            System.out.println("Milk is already selected");
        }
            else
        {
            chkMilk.click();
        }

            // Butter
        WebElement chkButter = driver.findElement(By.cssSelector("input[type=\"checkbox\"][value=\"Butter\"]"));
        if (chkButter.isSelected()){
            System.out.println("Butter is already selected");
        }
        else
        {
            chkButter.click();
        }

        WebElement chkCheese = driver.findElement(By.cssSelector("input[type=\"checkbox\"][value=\"Cheese\"]"));
        if (chkCheese.isSelected()){
            System.out.println("Cheese is already selected");
        }
        else
        {
            chkCheese.click();
        }

        driver.close();
    }
}
