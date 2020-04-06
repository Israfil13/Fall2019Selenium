package com.automation.tests.Class.Homework3;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase6 {

    private WebDriver driver;
    private By copyBy=By.linkText("Copy");

    private By signupmail=By.linkText("Sign Up For Mailing List");
    private By fullname=By.name("full_name");
    private By emailsignup=By.name("email");
    private By signupbutton=By.name("wooden_spoon");
    private By signUpmessage=By.tagName("h3");
    private  By subscriptionEmail=By.xpath("//tr[@class='hidden-xs hidden-sm klikaciRadek newMail'][1]");
    private By emailfrom=By.id("odesilatel");
    private By emailsubject=By.id("predmet");

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get("https://www.tempmailaddress.com/");
    }

   @Test
    public void Test6(){

        driver.findElement(copyBy).click();
        String email=driver.findElement(By.id("email")).getText();
        BrowserUtils.wait(3);
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        BrowserUtils.wait(3);
        driver.findElement(signupmail).click();
        driver.findElement(fullname).sendKeys("Mr.Robot");
        driver.findElement(emailsignup).sendKeys(email);
        driver.findElement(signupbutton).click();
        BrowserUtils.wait(2);

        WebElement signupMessage=driver.findElement(signUpmessage);
        Assert.assertTrue(signupMessage.isDisplayed());

        driver.navigate().to("https://www.tempmailaddress.com/");
        BrowserUtils.wait(5);
        String subscrip=driver.findElement(subscriptionEmail).getText();

        Assert.assertTrue(subscrip.contains("practice.cybertekschool.com"));

        driver.findElement(subscriptionEmail).click();
        String expected="do-not-reply@practice.cybertekschool.com";
        String actual=driver.findElement(emailfrom).getText();
        Assert.assertEquals(actual,expected);


       String expected2="Thanks for subscribing to practice.cybertekschool.com!";
       String actual2=driver.findElement(emailsubject).getText();
       Assert.assertEquals(actual2,expected2);


    }






@AfterMethod
public void  teardown(){
        driver.quit();
}

}
