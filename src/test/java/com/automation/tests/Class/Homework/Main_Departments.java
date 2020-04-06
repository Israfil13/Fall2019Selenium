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

public class Main_Departments {
private WebDriver driver;

    @Test
    public void test(){

        List<WebElement> maindepartaments=driver.findElements(By.cssSelector(".fsdDeptTitle"));
        List<WebElement> alldepartments=driver.findElements(By.cssSelector("#searchDropdownBox>option"));

        for (int i = 0; i < maindepartaments.size(); i++) {
            for (int j = 0; j <alldepartments.size() ; j++) {
             String maineach=maindepartaments.get(i).getText();
             String alleach=alldepartments.get(j).getText();
               Assert.assertTrue(maineach==alleach);
            }
        }

    }




    @BeforeMethod
    public void setup(){
        driver= DriverFactory.createDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/gp/site-directory");
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }



}
