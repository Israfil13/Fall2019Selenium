package com.automation.tests.Class.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practic  {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver= new ChromeDriver();
        driver.get("http://acmilan.com");
        Thread.sleep(2000);
        WebElement milan=driver.findElement(By.tagName("h3"));
        System.out.println(milan.getText());
        Thread.sleep(3000);

        driver.quit();


    }
}
