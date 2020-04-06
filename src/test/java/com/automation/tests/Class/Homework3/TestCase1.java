package com.automation.tests.Class.Homework3;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TestCase1 {
    private WebDriver driver;

    private By successmesa=By.tagName("p");
    private By firstname=By.name("firstname");
    private By lastname=By.name("lastname");
    private By username=By.name("username");
    private By email=By.name("email");
    private By password=By.name("password");
    private By phone=By.name("phone");
    private By male=By.xpath("//input[@value='male']");
    private By female=By.xpath("//input[@value='female']");
    private By other=By.xpath("//input[@value='other']");
    private By birthday=By.name("birthday");
    private By job_title=By.name("job_title");
    private By department=By.name("department");
    private By cplusplus=By.xpath("//label[text()='C++']/preceding-sibling::input");
    private By java=By.xpath("//label[text()='Java']/preceding-sibling::input");
    private By javascript=By.xpath("//label[text()='javascript']/preceding-sibling::input");
    private By signup=By.id("wooden_spoon");



    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
        driver.get("http://practice.cybertekschool.com");
        BrowserUtils.wait(3);
        driver.findElement(By.linkText("Registration Form")).click();
        BrowserUtils.wait(3);
    }

//    @Test
    public void Test1(){
     driver.findElement(By.name("birthday")).sendKeys("wrong_dob");
       WebElement warningmessage= driver.findElement(By.xpath("//small[contains(text(),'The date of birth is not valid')]"));
        Assert.assertTrue(warningmessage.isDisplayed());
        BrowserUtils.wait(3);
    }

//    @Test
    public void Test2(){
        List<WebElement> languagelist=driver.findElements(By.xpath("//div[@class='form-check form-check-inline']"));
       for (WebElement each:languagelist){
           Assert.assertTrue(each.isDisplayed());
           BrowserUtils.wait(3);
       }

    }

//        @Test
    public void Test3(){
        driver.findElement(By.name("firstname")).sendKeys("a");
       WebElement warningmessage=driver.findElement(By.xpath("//small[contains(text(),'first name is required')]/following-sibling::small[1]"));
//        WebElement warningMessage = driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']"));
    Assert.assertTrue(warningmessage.isDisplayed());
    }



//    @Test
    public void Test4(){
        driver.findElement(By.name("lastname")).sendKeys("a");
        WebElement warningMessage = driver.findElement(By.xpath("//small[text()='The last name must be more than 2 and less than 64 characters long']"));
        Assert.assertTrue(warningMessage.isDisplayed());
    }


    @Test
    public void Test5(){
        driver.findElement(firstname).sendKeys("Kazim");
        driver.findElement(lastname).sendKeys("Zazanqayev");
        driver.findElement(username).sendKeys("ZaZaKazim");
        driver.findElement(email).sendKeys("adad@afa.com");
        driver.findElement(phone).sendKeys("111-111-1111");
        driver.findElement(password).sendKeys("KazimKAzim");
        driver.findElement(firstname).sendKeys("Kazim");
        driver.findElement(male).click();
        driver.findElement(birthday).sendKeys("01/01/1990");
        Select select=new Select(driver.findElement(department));
        select.selectByVisibleText("Accounting Office");

        BrowserUtils.wait(2);

        Select jobtitle=new Select(driver.findElement(job_title));
        jobtitle.selectByVisibleText("SDET");
        BrowserUtils.wait(2);
        driver.findElement(java).click();
        BrowserUtils.wait(2);
        driver.findElement(signup).click();
        BrowserUtils.wait(2);
        String expected="You've successfully completed registration!";
        String actual=driver.findElement(By.tagName("p")).getText();

        Assert.assertEquals(actual,expected);


    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }



}
