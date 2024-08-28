package com.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class A05EchoEchoCheckBoxes {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://echoecho.com/htmlforms09.htm");

        List<WebElement> chkBoxes = driver.findElements(By.cssSelector("input[type=\"checkbox\"][name^=\"option\"]"));

        for (WebElement chk : chkBoxes)
        {
            System.out.println(chk.getText());
            System.out.println("Before......");
            System.out.println(chk.getAttribute("Value")+ " is selected : " + chk.isSelected());
            System.out.println(chk.getAttribute("Value") + " is enabled : " + chk.isEnabled());
            System.out.println(chk.getAttribute("Value") + " is displayed : " + chk.isDisplayed());
            if (!chk.isSelected())
                chk.click();
            System.out.println("\nAfter......");
            System.out.println(chk.getAttribute("Value") + " is selected : " + chk.isSelected());
            System.out.println(chk.getAttribute("Value") + " is enabled : " + chk.isEnabled());
            System.out.println(chk.getAttribute("Value") + " is displayed : " + chk.isDisplayed());
        }

        driver.close();
    }
}
