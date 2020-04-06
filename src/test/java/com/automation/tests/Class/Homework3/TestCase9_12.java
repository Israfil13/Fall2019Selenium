package com.automation.tests.Class.Homework3;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase9_12 {
    private WebDriver driver;

    @Test
    public void Test9(){
        driver.findElement(By.linkText("Status Codes")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.linkText("200")).click();
        String result=driver.findElement(By.tagName("p")).getText();
        Assert.assertTrue(result.contains("This page returned a 200 status code."));

    }

    @Test
    public void Test10(){
        driver.findElement(By.linkText("Status Codes")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.linkText("301")).click();
        String result=driver.findElement(By.tagName("p")).getText();
        Assert.assertTrue(result.contains("This page returned a 301 status code."));

    }


    @Test
    public void Test11(){
        driver.findElement(By.linkText("Status Codes")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.linkText("404")).click();
        String result=driver.findElement(By.tagName("p")).getText();
        Assert.assertTrue(result.contains("This page returned a 404 status code."));

    }

    @Test
    public void Test12(){
        driver.findElement(By.linkText("Status Codes")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.linkText("500")).click();
        String result=driver.findElement(By.tagName("p")).getText();
        Assert.assertTrue(result.contains("This page returned a 500 status code."));

    }












    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        BrowserUtils.wait(3);

    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
