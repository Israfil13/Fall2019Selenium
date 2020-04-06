package com.automation.tests.vytrack.LoginPage.Fleet;

import com.automation.Pages.Fleet.VehiclesPage;
import com.automation.Pages.Login.LoginPage;
import com.automation.tests.vytrack.LoginPage.AbstractTestBase;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;



    public class NewVehiclesPageTest extends AbstractTestBase {

        @Test
        public void verifyTitle(){
            LoginPage loginPage=new LoginPage();
            VehiclesPage vehiclesPage=new VehiclesPage();

            loginPage.login();
            vehiclesPage.navigateto("Fleet","Vehicles");

            String expectedTitle = "All - Car - Entities - System - Car - Entities - System";
            String actualTitle = Driver.getDriver().getTitle();
            Assert.assertEquals(actualTitle, expectedTitle);
        }
        }


