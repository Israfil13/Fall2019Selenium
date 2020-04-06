package com.automation.tests.Class.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBoxesTest {
    public static void main(String[] args) {

        WebDriver driver= DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");

        List<WebElement> checkboxlist=driver.findElements(By.tagName("input"));

        BrowserUtils.wait(2);

        for (int i = 0; i <checkboxlist.size() ; i++) {
            if (!checkboxlist.get(0).isSelected() && checkboxlist.get(1).isSelected()){
                System.out.println("Test Passed");
            }else {
                System.out.println("Test Failed");
            }
        }

        checkboxlist.get(0).click();
        BrowserUtils.wait(2);

        if (checkboxlist.get(0).isSelected()){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }





        driver.quit();

    }
}
