package com.automation.tests.Class.day11;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class WebTables {


        private WebDriver driver;


        @Test
    public void getColumnNames(){
//        List<WebElement> headers=driver.findElements(By.xpath("//table[1]//th"));
        List<WebElement> columnNames = driver.findElements(By.xpath("//table[1]//th"));
        List<String> expected= Arrays.asList("Last Name", "First Name", "Email", "Due", "Web Site", "Action");

        for (WebElement each :columnNames){
            System.out.println(each.getText());
        }

        Assert.assertEquals(BrowserUtils.getTextFromWebEelements(columnNames),expected);

    }

        @Test
        public void verifyrowcount(){
            List<WebElement> rows=driver.findElements(By.xpath("//table[1]//tbody//tr"));
            Assert.assertEquals(rows.size(),4);
        }


        public void getspecificColumn(){
            List<WebElement> column=driver.findElements(By.xpath("//table[1]//tbody//tr//td[5]"));

            System.out.println(BrowserUtils.getTextFromWebEelements(column));

        }

@Test
    public void deleteRowTest(){
            WebElement delete=driver.findElement(By.xpath("//table[1]//td[text()='jsmith@gmail.com']//following-sibling::td//a[text()='delete']"));
//           //table[1]//td[text()='jsmith@gmail.com']/..//a[2]
            delete.click();

            BrowserUtils.wait(3);

            int rows=driver.findElements(By.xpath("//table[1]//tbody//tr")).size();

            Assert.assertEquals(rows,3);

            List<WebElement> emails= driver.findElements(By.xpath("//table[1]//td[text()='jsmith@gmail.com']"));

            Assert.assertTrue(emails.isEmpty());

    }

    @Test
    public void getColumnINdexByName(){
            String expected="Email";
            int index=0;
            List<WebElement> columns=driver.findElements(By.xpath("//table[1]//th"));
        for (int i = 0; i < columns.size(); i++) {
            if (columns.get(i).getText().equals(expected)){
                System.out.println(String.format("Column name: %s, position %s",columns.get(i).getText(), i));
                index=i+1;
            }
        }
        Assert.assertEquals(index,3);
    }

        @Test
        public void getSpecificCell(){

            String expected="http://www.frank.com";

            int row=2;
            int column=5;

            String xpath="//table[1]//tbody//tr["+row+"]//td["+column+"]";
            WebElement cell=driver.findElement(By.xpath(xpath));
            Assert.assertEquals(cell.getText(),expected);

        }




        @BeforeMethod
        public void setup() {
            driver = DriverFactory.createDriver("chrome");

            driver.get("http://practice.cybertekschool.com/tables");
            driver.manage().window().maximize();
        }
        @AfterMethod
        public void teardown() {
            BrowserUtils.wait(3);
            driver.quit();
        }
}
