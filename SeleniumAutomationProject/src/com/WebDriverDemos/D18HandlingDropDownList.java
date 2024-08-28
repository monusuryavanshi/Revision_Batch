package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class D18HandlingDropDownList {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://register.rediff.com/register/register.php?FormName=user_details");

        WebElement drpList = driver.findElement(By.id("country"));
        Select count = new Select(drpList);

        System.out.println("Selected Country is : "+count.getFirstSelectedOption().getText());
        List<WebElement> countryList = count.getOptions();
        System.out.println("Total Count of Countries :"+countryList.size());
        int i = 0;
        for (WebElement c : countryList){
            System.out.println(i + "." +c.getText());
            i++;
        }
        count.selectByVisibleText("Turkey");
        // or
        count.selectByValue("214");
        // or
        count.selectByIndex(111);
        System.out.println("Selected Country is :" +count.getFirstSelectedOption().getText());
        driver.close();

    }
}
