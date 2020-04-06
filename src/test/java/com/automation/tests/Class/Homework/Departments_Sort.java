package com.automation.tests.Class.Homework;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Departments_Sort {

    private WebDriver driver;
@Test
   public void test1(){

     String actual=  driver.findElement(By.xpath("//span[@class='nav-search-label']")).getText();
     String expected="All";

    Assert.assertEquals(actual,expected);
   }

   @Test
    public void test2(){
       List<WebElement> departments=driver.findElements(By.cssSelector("#searchDropdownBox>option"));

       for (int i = 0; i < departments.size()-1; i++) {

           String value=departments.get(i).getText();
           String nextvalue=departments.get(i+1).getText();

           System.out.println(value.compareTo(nextvalue));



           Assert.assertTrue( !(value.compareTo(nextvalue)<0));

       }



    }








    @BeforeMethod
    public void setup(){
        driver= DriverFactory.createDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
