package com.automation.tests.Class.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Xpath {
    public static void main(String[] args) {

        WebDriver driver= DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        BrowserUtils.wait(3);
//        driver.findElement(By.xpath("//*[@id=\"button_golden\"]")).click();
        driver.findElement(By.xpath("//button[@onclick='button1()']")).click();
        driver.findElement(By.xpath("//button[text()='Button 2']")).click();
        driver.findElement(By.xpath("//button[starts-with(@id,'button_')]")).click();
        driver.findElement(By.xpath("//button[contains(@id,'button_')]")).click();
        driver.findElement(By.xpath("//button[5]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'click')]")).click();

        driver.get("https://www.amazon.com/");
        driver.findElement(By.xpath("//*[@id=\"nav-link-prime\"]/span[2]")).click();







        BrowserUtils.wait(3);
        driver.quit();

    }
}
