package com.automation.tests.vytrack.LoginPage.Login;

import com.automation.Pages.Login.LoginPage;
import com.automation.tests.vytrack.LoginPage.AbstractTestBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewLoginTests extends AbstractTestBase {

    @Test(groups = "smoke")
    public void verifyPageTitle(){
        //test --> ExtentTest object
        //we must add to every test at the beginning
        //test = report.createTest("Test name");
        test = report.createTest("Verify page title");
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboard");
        //if assertion passed, it will set test status in report to passed
        test.pass("Page title Dashboard was verified");
    }

    /**
     * Enter wrong credentials and verify warning message
     *
     */

    @Test
    public void verifyWarningMessage(){
        test = report.createTest("Verify Warning Message");
        LoginPage loginPage = new LoginPage();
        loginPage.login("wrong", "wrong");
        Assert.assertEquals(loginPage.getWarningMessageText(), "Invalid user name or password.");
        //take a screenshot
        BrowserUtils.getScreenshot("warning_message");
        test.pass("Warning Message:Invalid user name or password.-was verified");
    }

    @Test(dataProvider = "credentials")
    public void loginWithDDT(String username,String password){
        test = report.createTest("Verify page title "+username);
        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);
        test.info("Login as "+username);
        Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboard");
        //if assertion passed, it will set test status in report to passed
        test.pass("Page title Dashboard was verified");
    }


    @DataProvider
    public Object[][] credentials(){
        return new Object[][]{
                {"storemanager85", "UserUser123"},
                {"salesmanager110","UserUser123"},
                {"user16",         "UserUser123"}
        };

    }
}
