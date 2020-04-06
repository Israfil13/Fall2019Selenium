package com.automation.tests.Class.OfficeHour;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium1 {
    public static void main(String[] args)throws  Exception {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        driver.get("http://etsy.com");
        Thread.sleep(2000);
        WebElement search=driver.findElement(By.id("global-enhancements-search-query"));
        search.sendKeys("handbags", Keys.ENTER);
        Thread.sleep(3000);
        driver.quit();



    }
}
