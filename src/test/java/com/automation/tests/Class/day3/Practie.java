package com.automation.tests.Class.day3;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Practie {
    public static void main(String[] args) throws Exception {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
        Thread.sleep(3000);
//        List<WebElement> listofrows=driver.findElements(By.className("list-group-item"));
      //  List<WebElement> alllinks=driver.findElements(By.tagName("a"));

//        driver.findElement(By.linkText("Autocomplete")).click();
//        driver.navigate().back();

//        WebElement elemetn2=driver.findElement(By.partialLinkText("Drag"));
//        elemetn2.click();



//        WebElement xpathrelative=driver.findElement(By.xpath("html/body/div/div[2]/div/ul/li[11]/a"));
//        xpathrelative.click();

//        WebElement xpathindependent=driver.findElement(By.xpath("//a[.='Context Menu']"));
//        WebElement xpathindependent2=driver.findElement(By.xpath("//a[@href='/drag_and_drop']"));
////        System.out.println(xpathindependent.getText());
//        xpathindependent2.click();

        driver.findElement(By.xpath("//a[.='Registration Form']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@value='java']")).click();
        Thread.sleep(3000);

//        System.out.println("all links"+ alllinks.size());
//        System.out.println(listofrows.size());
        Thread.sleep(3000);
        driver.quit();




    }
}
