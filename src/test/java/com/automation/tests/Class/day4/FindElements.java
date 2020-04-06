package com.automation.tests.Class.day4;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FindElements {
    public static void main(String[] args) throws  Exception {
        WebDriver driver= DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        Thread.sleep(3000);

        List<WebElement> listlink=driver.findElements(By.tagName("a"));

        for (WebElement each:listlink){
            System.out.println(each.getText());
            System.out.println(each.getAttribute("href"));
        }

        for (int i = 1; i < listlink.size(); i++) {
            listlink.get(i).click();
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
          listlink=driver.findElements(By.tagName("a"));
        }


        driver.quit();
    }
}
