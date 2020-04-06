package com.automation.tests.Class.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBoxes {
    public static void main(String[] args) {
        WebDriver driver= DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);

        List<WebElement> listcheckbox=driver.findElements(By.tagName("input"));
//        listcheckbox.get(0).click();

        BrowserUtils.wait(2);

        for (int i = 0; i <listcheckbox.size() ; i++) {
            if (!listcheckbox.get(i).isSelected()) {
                listcheckbox.get(i).click();
                System.out.println(i+1+" checkbox is selected");
            }else{
                System.out.println(i+1+" checkbox was not selected");

            }
        }

        BrowserUtils.wait(2);
        driver.quit();


    }
}
