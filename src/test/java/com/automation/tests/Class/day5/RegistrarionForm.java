package com.automation.tests.Class.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RegistrarionForm {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/registration_form");
        BrowserUtils.wait(5);
        driver.findElement(By.name("firstname")).sendKeys("john");
        driver.findElement(By.name("lastname")).sendKeys("SMith");
        driver.findElement(By.name("username")).sendKeys("lalala");
        driver.findElement(By.name("email")).sendKeys("lalala@.afr.com");
        driver.findElement(By.name("email")).sendKeys("lalala@.afr.com");
        driver.findElement(By.name("password")).sendKeys("fffsaa");
        driver.findElement(By.name("phone")).sendKeys("555-555-5555");
        List<WebElement> genderlist=driver.findElements(By.name("gender"));
        genderlist.get(0).click();
        driver.findElement(By.name("birthday")).sendKeys("01/05/1990");
        driver.findElement(By.id("inlineCheckbox2")).click();

        BrowserUtils.wait(2);

        driver.quit();




    }
}
