package com.automation.tests.Class.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Udemy_Locators {
    public static void main(String[] args)throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://login.salesforce.com/");

//       driver.findElement(By.id("username")).sendKeys("hello");
//       driver.findElement(By.name("pw")).sendKeys("123456");
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("asdasdads");
        driver.findElement(By.cssSelector("input[name='pw']")).sendKeys("1313");

//        driver.findElement(By.cssSelector("#username")).sendKeys("aaaaa")
//       driver.findElement(By.id("Login")).click();
//       driver.findElement((By.cssSelector("div#error.loginError"))).getText();
       driver.findElement(By.cssSelector("input[value='Log In']")).getText();
       driver.findElement(By.cssSelector("a#forgot_password_link")).click();
       driver.findElement(By.xpath("//a=[@id='a#forgot_password_link']"));
       driver.quit();




    }
}
