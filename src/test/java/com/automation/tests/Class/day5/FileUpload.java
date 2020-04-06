package com.automation.tests.Class.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUpload {
    public static void main(String[] args) {
        WebDriver driver= DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/upload");
        BrowserUtils.wait(3);
        WebElement upload=driver.findElement(By.id("file-upload"));
        String filePath=System.getProperty("user.dir")+"/pom.xml";
        String filePath2="C:/Users/hajiy/Desktop/Muxtar's Note Day 1-30.rtf";

        upload.sendKeys(filePath2);
        driver.findElement(By.id("file-submit")).click();
        BrowserUtils.wait(3);
        driver.quit();


    }
}
