package com.automation.tests.Class.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NoSelectDropDown {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        driver.findElement(By.id("dropdownMenuLink")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.linkText("Amazon")).click();
        BrowserUtils.wait(2);

        //<a class="dropdown-item" href="https://www.amazon.com/">Amazon</a>
        BrowserUtils.wait(3);
        List<WebElement> allLinks = driver.findElements(By.className("dropdown-item"));
        for (WebElement link: allLinks){
            BrowserUtils.wait(2);

            System.out.println(link.getText()+" : "+link.getAttribute("href"));
        }
        driver.findElement(By.linkText("Etsy")).click();//click on option
            BrowserUtils.wait(1);
        driver.quit();

    }
}
