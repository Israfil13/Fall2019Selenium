package com.automation.tests.Class.day7;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CSS {
    public static void main(String[] args) {
        WebDriver driver= DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        driver.findElement(By.cssSelector(".h3"));
        driver.findElement(By.cssSelector(".nav-link"));
        driver.findElement(By.cssSelector("[onclick='button1()'"));
        driver.findElement(By.cssSelector("[name='button2'"));


    }
}
