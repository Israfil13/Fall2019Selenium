package com.automation.tests.Class.Homework;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Valid_Links {
    private WebDriver driver;

    @Test
    public  void test(){
        driver.get("https://www.w3schools.com");
        List<WebElement> links=driver.findElements(By.tagName("a"));
        for (WebElement eachllink:links){
            if (eachllink.isDisplayed()){
                System.out.println(eachllink.getText() + ":"+ eachllink.getAttribute("href"));
            }
        }
    }






    @BeforeMethod
    public void setup(){
        driver= DriverFactory.createDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
