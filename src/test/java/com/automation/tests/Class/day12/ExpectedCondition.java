package com.automation.tests.Class.day12;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExpectedCondition {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading/2");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test
    public void waitForVisibility() {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        WebDriverWait wait=new WebDriverWait(driver,10);
        driver.findElement(By.tagName("button")).click();
        WebElement username=driver.findElement(By.name("username"));
        WebElement password=driver.findElement(By.name("password"));
        WebElement button=driver.findElement(By.cssSelector("button[type=submit"));

        wait.until(ExpectedConditions.visibilityOf(username)).sendKeys("tomsmith");
        wait.until(ExpectedConditions.visibilityOf(password)).sendKeys("SuperSecretPassword");
        wait.until(ExpectedConditions.visibilityOf(button));
        wait.until(ExpectedConditions.elementToBeClickable(button)).click();

        String expected="Welcome to the Secure Area. When you are done click logout below.";
        String actual= driver.findElement(By.tagName("h4")).getText();

        Assert.assertEquals(actual,expected);




    }

    @Test
    public void elemetToBEClickableTest(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/5");

        WebDriverWait wait=new WebDriverWait(driver,10);
        WebElement username=driver.findElement(By.name("username"));
        WebElement password=driver.findElement(By.name("password"));
        WebElement button=driver.findElement(By.cssSelector("button[type=submit"));
//        BrowserUtils.wait(5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loadingoverlay")));
        wait.until(ExpectedConditions.elementToBeClickable(button));
        username.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword");
        button.click();
        String expected="Welcome to the Secure Area. When you are done click logout below.";
        String actual= driver.findElement(By.tagName("h4")).getText();

        Assert.assertEquals(actual,expected);

    }

}
