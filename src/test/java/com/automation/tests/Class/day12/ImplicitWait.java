package com.automation.tests.Class.day12;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWait {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading/2");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test
    public void waitTest(){
        driver.findElement(By.tagName("button")).click();
        String actual=driver.findElement(By.id("finish")).getText();

        Assert.assertEquals(actual,"Hello World!");

    }


}
