package com.automation.tests.Class.day4;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class VerifyTheLinkIsGone {
    public static void main(String[] args) throws  Exception{
        //Interview question:
        //how to check if element does not exist any more

        WebDriver driver= DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        driver.findElement(By.id("disappearing_button")).click();
        Thread.sleep(2000);

        if (driver.findElements(By.id("disappearing_button")).size()==0){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }

        Thread.sleep(2000);

        List<WebElement> buttons= driver.findElements(By.tagName("button"));

        for (WebElement each:buttons){
            each.click();
            Thread.sleep(2000);
        }

        driver.quit();

    }
}
