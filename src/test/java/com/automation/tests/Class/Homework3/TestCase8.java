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

public class TestCase8 {
    private WebDriver driver;

    @Test
    public void Test8 (){
        driver.findElement(By.linkText("Autocomplete")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        WebElement result=driver.findElement(By.id("result"));
        Assert.assertTrue(result.isDisplayed());
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
