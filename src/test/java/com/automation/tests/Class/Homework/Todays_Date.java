package com.automation.tests.Class.Homework;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class Todays_Date {

  private   WebDriver driver;

  @Test
  public void Test1(){
      driver.get("http://practice.cybertekschool.com/dropdown");
//     String year= driver.findElement(By.xpath("//select[@id='year']//option[1]")).getText();
//     String month= driver.findElement(By.xpath("//select[@id='month']//option[3]")).getText();
//     String day= driver.findElement(By.xpath("//select[@id='day']//option[24]")).getText();

      String year= driver.findElement(By.id("year")).getAttribute("value");
      String month= driver.findElement(By.id("month")).getAttribute("value");
      String day= driver.findElement(By.id("day")).getAttribute("value");

      int monthint=Integer.parseInt(month)+1;
      String monthstr=String.valueOf(monthint);
      String expecteddate=year+","+monthint+","+day;



//      String expecteddate=month+" "+day+", "+year;
    String currentdate= LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy,M,dd"));
////      String formattedDate = LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
      Assert.assertEquals(currentdate,expecteddate);

  }
















  @BeforeMethod
    public void setup(){
        driver=DriverFactory.createDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void teardown(){
      driver.quit();
    }



}
