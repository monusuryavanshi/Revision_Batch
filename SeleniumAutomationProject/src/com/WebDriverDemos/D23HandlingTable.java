package com.WebDriverDemos;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.*;

public class D23HandlingTable {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");

        // display column headers
        List<WebElement>headers = driver.findElements(By.xpath("//table[@class=\"dataTable\"]//tr/th"));
        System.out.println("==========Column Headers as : ===========");
        for (WebElement h : headers)
        {
            System.out.println(h.getText());
        }


        // display number of rows
        List<WebElement>rows = driver.findElements(By.xpath("//table[@class=\"dataTable\"]/tbody/tr"));
        System.out.println("Total number of Rows : " + rows.size());

        // display random row
        Random rnd = new Random();
        int i = rnd.nextInt(rows.size()); // //Generates any random number in the range of 0 to 10
        // int i = rnd.nextInt(11); // or can specify this way for specific index
        System.out.println(i);
        System.out.println(rows.get(i).getText()); // this will show specified row details by specifying index or by random class variable

        // Assignment Works

        // no.1
        // display list of companies
        List<WebElement>companies = driver.findElements(By.xpath("//table[@class=\"dataTable\"]/tbody/tr/td[1]/a"));
        System.out.println("Total companies : " + companies.size());
        System.out.println("==========Company List as : ===========");
        for (WebElement c : companies)
        {
            System.out.println(c.getText());
        }

        // no. 2
        // display maximum current price
        List<WebElement>price = driver.findElements(By.xpath("//table[@class=\"dataTable\"]/tbody/tr/td[4]"));

        Double[] cpArray = new Double[price.size()];
        for (int p = 0; p <price.size(); p++)
        {
            String pValue = price.get(p).getText();
            pValue = pValue.replace(",", "");
            cpArray[p] = Double.parseDouble(pValue);
            System.out.println(cpArray[p]);
        }
        Arrays.sort(cpArray);
        System.out.println("Highest Value : " + cpArray[cpArray.length-1]);

        driver.close();

    }
}
