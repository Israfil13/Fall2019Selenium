package com.automation.tests.Class.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.WebDriver;

public class Practice {
    public static void main(String[] args) {
        WebDriver driver= DriverFactory.createDriver("chrome");
        driver.get("http://amazon.com");
        BrowserUtils.wait(2);
        driver.manage().window().maximize();
        driver.switchTo().frame("ape_Gateway_desktop-ad-center-1_desktop_iframe");
        BrowserUtils.wait(2);
        driver.quit();
    }
}
