package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args)throws Exception {
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();
        driver.get("http://google.com");
        Thread.sleep(3000);

        String titlre=driver.getTitle();
        String ecxpectedTitle="Google";
        if (ecxpectedTitle.equals(titlre)) {

            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }
        System.out.println("titlre = " + titlre);
        driver.close();

    }
}
