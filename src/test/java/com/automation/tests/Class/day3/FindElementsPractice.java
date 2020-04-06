package com.automation.tests.Class.day3;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindElementsPractice {
    public static void main(String[] args) throws Exception{
      WebDriver driver= DriverFactory.createDriver("chrome");
      driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement name=driver.findElement(By.name("full_name"));
        name.sendKeys("Israfil");
        Thread.sleep(3000);

        WebElement password=driver.findElement(By.name("email"));
        password.sendKeys("adad@afaf.com");
        Thread.sleep(3000);

        WebElement signup=driver.findElement(By.className("radius"));
        signup.click();

        WebElement message=driver.findElement(By.className("subheader"));
       String expected="Thank you for signing up. Click the button below to return to the home page.";
      String actual=message.getText();
        if (actual.equals(expected)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }


        Thread.sleep(3000);
        driver.quit();
    }
}
