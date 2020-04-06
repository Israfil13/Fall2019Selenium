package com.automation.tests.Class.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonTest {
    public static void main(String[] args) {

       WebDriver driver= DriverFactory.createDriver("chrome");
       driver.get("http://practice.cybertekschool.com/radio_buttons");
       driver.manage().window().maximize();
        BrowserUtils.wait(2);
        WebElement blackbutton=driver.findElement(By.id("black"));

        if (blackbutton.isDisplayed()&&blackbutton.isEnabled()){
            System.out.println("Clicked on Black Button");
            blackbutton.click();
        }else {
            System.out.println("Failed to Click on Black Button");
        }

        if (blackbutton.isSelected()){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failes");
        }

        if (driver.findElements(By.id("orange")).size()==0){
            System.out.println("Not found");
        }

        driver.quit();
    }
}
