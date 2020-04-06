package com.automation.tests.Class.day12;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebOrders {
    private WebDriver driver;
    private WebDriverWait wait;
    @BeforeMethod
    public void setup(){
        driver= DriverFactory.createDriver("chrome");
        wait=new WebDriverWait(driver,10);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders");
        driver.manage().window().maximize();
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test", Keys.ENTER);
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test
    public void checkboxTest(){
        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        BrowserUtils.wait(3);
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        for (WebElement each : checkboxes){
            Assert.assertTrue(each.isSelected());
        }
    }

    @Test
    public void changezipcode(){
       String zipCode= driver.findElement(By.xpath("//td[text()='Steve Johns']//following-sibling::td[7]")).getText();
       String expected="21233";
        Assert.assertEquals(zipCode,expected);

        driver.findElement(By.xpath("//td[text()='Steve Johns']//following-sibling::td//input[@alt='Edit']")).click();
       WebElement zipBox= driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));
       zipBox.clear();
       zipBox.sendKeys("20002");
       driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton")).click();
        String updatedzipCode= driver.findElement(By.xpath("//td[text()='Steve Johns']//following-sibling::td[7]")).getText();

        Assert.assertEquals(updatedzipCode,"20002");



    }




}
