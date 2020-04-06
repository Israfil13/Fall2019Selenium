package com.automation.tests.Class.Homework;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Links {

    private WebDriver driver;

    @Test
    public void test(){
        driver.get("https://www.selenium.dev/documentation/en/");

       List<WebElement> links= driver.findElements(By.tagName("a"));
      List<WebElement> displayedlinks= Arrays.asList();
       for (WebElement eachlink:links){
           if (eachlink.isDisplayed()){
               String expected=eachlink.getAttribute("href");
               System.out.println(eachlink.getAttribute("href"));
                eachlink.click();
//                String actual=eachlink.getAttribute("href");
//                Assert.assertEquals(actual,expected);


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
