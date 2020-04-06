package com.automation.tests.Class.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTask {
    public static void main(String[] args) throws  Exception{

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("http://google.com");
        Thread.sleep(2000);
        WebElement search= driver.findElement(By.name("q"));
        search.sendKeys("Java", Keys.ENTER);
        Thread.sleep(3000);
        WebElement news=driver.findElement(By.linkText("News"));
        news.click();
        Thread.sleep(2000);
        driver.quit();


    }
}
