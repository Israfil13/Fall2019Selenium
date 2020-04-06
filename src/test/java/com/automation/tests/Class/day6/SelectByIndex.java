package com.automation.tests.Class.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByIndex {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        Select stateSelect = new Select(driver.findElement(By.id("state")));

        stateSelect.selectByIndex(9);

        stateSelect.selectByIndex(stateSelect.getOptions().size()-1);

        List<WebElement> staelist=stateSelect.getOptions();

        for (int i = 0; i <staelist.size() ; i++) {
            stateSelect.selectByIndex(i);
            System.out.println(staelist.get(i).getText());
        }


        BrowserUtils.wait(3);
        driver.quit();
    }
}
