package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args)throws Exception {
        WebDriverManager.chromedriver().setup();
//        System.setProperty("webdriver.chrome.driver")

        WebDriver driver=new ChromeDriver();
        driver.get("http://google.com");
        driver.manage().window().maximize();
        Thread.sleep(1000);

        driver.navigate().to("http://amazon.com");
        Thread.sleep(3000);

        if (driver.getTitle().toLowerCase().contains("amazon")){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }

        driver.navigate().back();
        Thread.sleep(3000);

        verifyEquals(driver.getTitle(),"Amazon");

        driver.navigate().refresh();
        driver.close();

//        String titlre=driver.getTitle();
//        String ecxpectedTitle="Google";
//        if (ecxpectedTitle.equals(titlre)) {
//
//            System.out.println("Test Passed");
//        }else{
//            System.out.println("Test Failed");
//        }
//        System.out.println("titlre = " + titlre);


    }


    public static void verifyEquals(String arg1,String arg2){
        if (arg1.equals(arg2)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }

    }
}
