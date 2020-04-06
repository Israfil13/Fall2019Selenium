package com.automation.tests.Class.day4;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Warm_Up_Task_Ebay {
    public static void main(String[] args) throws Exception{

//          ebay();
//           amazon();
         wikipedia();

    }
    public static void ebay() throws  Exception{
        WebDriver driver= DriverFactory.createDriver("chrome");
        driver.get("https://www.ebay.com/");
        Thread.sleep(3000);
        driver.findElement(By.id("gh-ac")).sendKeys("book");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@value='Search']")).click();
        Thread.sleep(2000);
        String searchresult=driver.findElement(By.className("srp-controls__count-heading")).getText().split(" ")[0];
        System.out.println(searchresult);

        driver.quit();
    }

    public static void amazon() throws  Exception{
        WebDriver driver= DriverFactory.createDriver("chrome");
        driver.get("https://www.amazon.com");
        Thread.sleep(2000);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("diapers", Keys.ENTER);
        Thread.sleep(2000);
        String expectedtitle="diapers";
//        System.out.println(driver.getTitle());
        if (driver.getTitle().contains(expectedtitle)){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }

        driver.quit();

    }

    public static void wikipedia() throws  Exception{
        WebDriver driver= DriverFactory.createDriver("chrome");
        driver.get("https://wikipedia.com");
        Thread.sleep(3000);
        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver",Keys.ENTER);
        Thread.sleep(3000);
        driver.findElement(By.partialLinkText("software")).click();
//      driver.findElement(By.xpath("//a[@href=/wiki/Selenium_(software)']"));



        String actualurl=driver.getCurrentUrl();
        System.out.println(actualurl);

        if (actualurl.endsWith("Selenium_(software)")){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }

        driver.quit();

    }




}
