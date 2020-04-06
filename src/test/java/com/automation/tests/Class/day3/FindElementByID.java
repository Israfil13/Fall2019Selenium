package com.automation.tests.Class.day3;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindElementByID {
    public static void main(String[] args) throws Exception {
      WebDriver driver= DriverFactory.createDriver("chrome");
      driver.get("http://practice.cybertekschool.com/login");
      driver.findElement(By.name("username")).sendKeys("tomsmith");
      Thread.sleep(3000);
      driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");

      Thread.sleep(3000);
      driver.findElement(By.id("wooden_spoon")).click();

      Thread.sleep(3000);


        Thread.sleep(3000);
      String expected= "Welcome to the Secure Area. When you are done click logout below.";
      String actual=driver.findElement(By.tagName("h4")).getText();

      if (actual.equalsIgnoreCase(expected)){
          System.out.println("Test Passed");
      }else{
          System.out.println("Test Failed");
      }

     WebElement logout=  driver.findElement(By.linkText("Logout"));
      String href=logout.getAttribute("href");
      String classname=logout.getAttribute("class");

        System.out.println(classname);
        System.out.println(href);
        logout.click();

        driver.findElement(By.name("username")).sendKeys("lalalal");
        driver.findElement(By.name("password")).sendKeys("Adadda");
        driver.findElement(By.id("wooden_spoon")).click();
        Thread.sleep(2000);

        WebElement errorMessage=driver.findElement(By.id("flash-messages"));

        System.out.println(errorMessage.getText());

        Thread.sleep(2000);
        driver.quit();

    }
}
