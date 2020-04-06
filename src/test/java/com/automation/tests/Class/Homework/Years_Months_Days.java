package com.automation.tests.Class.Homework;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Years_Months_Days {

    private WebDriver driver;
    private Select selectyear;
    private Select selectmonth;
    private Select selectdays;


        @Test
    public void test(){

        selectyear =new Select(driver.findElement(By.xpath("//select[@id='year']")));
        selectmonth =new Select(driver.findElement(By.xpath("//select[@id='month']")));


        List<WebElement> years=selectyear.getOptions();
        List<WebElement> month=selectmonth.getOptions();



            for (int i = 0; i <month.size() ; i++) {
                    Random random = new Random();
                    int year = random.nextInt(100);

                    selectyear.selectByIndex(year);
                    selectmonth.selectByIndex(i);


                    selectdays =new Select(driver.findElement(By.xpath("//select[@id='day']")));

                    BrowserUtils.wait(3);

                    List<WebElement> days=selectdays.getOptions();
                    List<WebElement> daysoption=driver.findElements(By.xpath("//select[@id='day']//option"));

                    selectdays.selectByIndex(days.size()-1);
                    BrowserUtils.wait(3);


                    String actual=selectdays.getFirstSelectedOption().getText();
                    String expected= String.valueOf(daysoption.size());
                    Assert.assertEquals(actual,expected);


//                    int actual=days.size();
//                    int expected=daysoption.size();
//
//                    Assert.assertTrue(actual==expected);

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


