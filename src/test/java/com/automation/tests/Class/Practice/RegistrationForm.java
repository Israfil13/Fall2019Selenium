package com.automation.tests.Class.Practice;

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

public class RegistrationForm {
    private String Url="http://practice.cybertekschool.com/registration_form";
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
    private By department=By.name("department");
    private By job_title=By.name("job_title");
    private By cplusplus=By.xpath("//label[text()='C++']/preceding-sibling::input");
    private By java=By.xpath("//label[text()='java']/preceding-sibling::input");
    private By javascript=By.xpath("//label[text()='javascript']/preceding-sibling::input");
    private By signup=By.id("wooden-spoon");



    @Test
    public void Test(){
        driver.findElement(firstname).sendKeys("Kazim");
        driver.findElement(lastname).sendKeys("Zazanqayev");
        driver.findElement(username).sendKeys("ZaZaKazim");
        driver.findElement(email).sendKeys("sdfKazim@zazsdfa.com");
        driver.findElement(phone).sendKeys("111-111-1111");
        driver.findElement(password).sendKeys("KazimKAzim");
        driver.findElement(firstname).sendKeys("Kazim");
        driver.findElement(male).click();
        driver.findElement(birthday).sendKeys("01/01/1990");
        Select departmentSelect=new Select(driver.findElement(department));
        departmentSelect.selectByVisibleText("Department of Agriculture");

        Select jobtitle=new Select(driver.findElement(job_title));
        jobtitle.selectByVisibleText("SDET");

        driver.findElement(java).click();
        driver.findElement(signup).click();

        BrowserUtils.wait(5);

        String expected="You've successfully completed registration";
        String actual=driver.findElement(By.tagName("p")).getText();

        Assert.assertEquals(actual,expected);

    }

    @Test
    public void verifynamelenght(){
        driver.findElement(firstname).sendKeys("a");
        BrowserUtils.wait(3);
        WebElement warning=driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']"));
        Assert.assertTrue(warning.isDisplayed());
    }


    @Test
    public void verifyAlphabetic(){
        driver.findElement(firstname).sendKeys("123");
        BrowserUtils.wait(3);
        WebElement warning=driver.findElement(By.xpath("//small[text()='first name can only consist of alphabetical letters']"));
        Assert.assertTrue(warning.isDisplayed());

    }


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Url);

    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
