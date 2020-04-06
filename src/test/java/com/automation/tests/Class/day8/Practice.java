package com.automation.tests.Class.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Practice {
   private WebDriver driver;
    @BeforeMethod
    public void beforeMethod(){
        WebDriverManager.chromedriver().version("79").setup();
        //ChromeOptions - use to customize browser for tests
        ChromeOptions chromeOptions = new ChromeOptions();
        //to ignore "Your connection is not private issue"
        chromeOptions.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();

}
    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }


    @Test
    public void loginTest(){
        driver.findElement(By.linkText("Form Authentication")).click();
        BrowserUtils.wait(2);

        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        driver.findElement(By.id("wooden_spoon")).click();

        BrowserUtils.wait(2);

        String expected="Welcome to the Secure Area. When you are done click logout below.";
        String actual=driver.findElement(By.className("subheader")).getText();

        Assert.assertEquals(actual,expected,"Sub-header message is not matching");

    }
        @Test
    public void forgoPassword(){
        driver.findElement(By.linkText("Forgot Password")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.name("email")).sendKeys("aaa@bb.com");
        driver.findElement(By.id("form_submit")).click();
        String expected="Your e-mail's been sent!";
        String actual=driver.findElement(By.name("confirmation_message")).getText();
        Assert.assertEquals(expected,actual);


    }

        @Test
    public void checkboxes(){
        driver.findElement(By.linkText("Checkboxes")).click();
        BrowserUtils.wait(2);
       WebElement checkbox1= driver.findElement(By.xpath("//input[1]"));
       checkbox1.click();
       Assert.assertTrue(checkbox1.isSelected());

    }





}
