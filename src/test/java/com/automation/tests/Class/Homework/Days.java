package com.automation.tests.Class.Homework;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;


public class Days {
    private WebDriver driver = Driver.getDriver();

    @Test
    public void test() {
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
        BrowserUtils.wait(2);
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        List<WebElement> labels = driver.findElements(By.xpath("//input[@type='checkbox']/following-sibling::label"));
        int counter = 0;
        while (counter < 3) {
            Random random = new Random();
            //gives you a number from 0 to bound (exclusive)
            int checkboxToSelect = random.nextInt(checkboxes.size());
            if (checkboxes.get(checkboxToSelect).isEnabled()) {
                checkboxes.get(checkboxToSelect).click();
                System.out.println("Selected :: " + labels.get(checkboxToSelect).getText());
                checkboxes.get(checkboxToSelect).click();
                if (labels.get(checkboxToSelect).getText().equals("Friday")) {
                    counter++;
                }
            }
        }
        driver.quit();
    }
}
