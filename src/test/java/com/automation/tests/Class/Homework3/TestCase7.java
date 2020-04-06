package com.automation.tests.Class.Homework3;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase7 {

    private WebDriver driver;


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        BrowserUtils.wait(3);

    }

    @Test
    public void Test7(){
        driver.findElement(By.linkText("File Upload")).click();
        String filepath="C:/Users/hajiy/Desktop/Hello.txt";
        BrowserUtils.wait(3);
        WebElement upload= driver.findElement(By.id("file-upload"));
        BrowserUtils.wait(3);

        upload.sendKeys(filepath);
        driver.findElement(By.id("file-submit")).click();
        BrowserUtils.wait(3);

        String expected="File Uploaded!";
        String actual=driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(actual,expected);

        WebElement subject=driver.findElement(By.id("uploaded-files"));
        Assert.assertTrue(subject.isDisplayed());





    }





    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
