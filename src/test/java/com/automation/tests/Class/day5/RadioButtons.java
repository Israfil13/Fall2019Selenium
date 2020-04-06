package com.automation.tests.Class.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RadioButtons {
    public static void main(String[] args) throws Exception{
       WebDriver driver = DriverFactory.createDriver("chrome");
       driver.get("http://practice.cybertekschool.com/radio_buttons");
       driver.manage().window().maximize();
      List<WebElement> listofbuttons= driver.findElements(By.tagName("input"));
        BrowserUtils.wait(2);


        for (WebElement each:listofbuttons){
            boolean isSelected=each.isSelected();
            String id=each.getAttribute("id");
            System.out.println(id+"is selected : "+isSelected);
            if (each.isEnabled()){
            each.click();
            System.out.println("Clicked on : "+id);
            BrowserUtils.wait(1);
            }else {
                System.out.println("Button is disables. not clicked : "+id);
            }



        }

        driver.quit();

    }
}
