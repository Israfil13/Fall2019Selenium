package com.automation.tests.Class.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IFrameTest {
    public static void main(String[] args) {
       WebDriver driver= DriverFactory.createDriver("chrome");
       driver.get("http://practice.cybertekschool.com/iframe");
        BrowserUtils.wait(4);
      driver.switchTo().frame("mce_0_ifr");
        WebElement textinput=driver.findElement(By.id("tinymce"));
        System.out.println(textinput.getText());
        BrowserUtils.wait(4);
        textinput.clear();
        textinput.sendKeys("Hello World");
        BrowserUtils.wait(4);

        driver.switchTo().defaultContent();

        WebElement heading = driver.findElement(By.tagName("h3"));
        System.out.println(heading.getText());
        driver.quit();

    }
}
