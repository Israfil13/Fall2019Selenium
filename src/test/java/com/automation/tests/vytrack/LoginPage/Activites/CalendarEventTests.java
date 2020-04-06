package com.automation.tests.vytrack.LoginPage.Activites;

import com.automation.Pages.Activities.Calendar_Events_Page;
import com.automation.Pages.Login.LoginPage;
import com.automation.tests.vytrack.LoginPage.AbstractTestBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DateTimeUtilities;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class CalendarEventTests extends AbstractTestBase {



        @Test
        public  void  defaultOptionTest(){
            test = report.createTest("Verify default login options");
            LoginPage loginPage=new LoginPage();
            Calendar_Events_Page calendar_events_page=new Calendar_Events_Page();

            loginPage.login();
            calendar_events_page.navigateto("Activities","Calendar Events");
            calendar_events_page.clickToCreateCalendarEvent();

            String actualStartDate=calendar_events_page.getStartDate();
            String expectedDate=DateTimeUtilities.getTodaysDate("MMM dd, yyyy");
            Assert.assertEquals( calendar_events_page.getOwnerName(), calendar_events_page.getCurrentUserName());
            Assert.assertEquals(actualStartDate,expectedDate);
            test.pass("Default options verified");
        }

        @Test
        public void diffrencebeetwenTime(){
            test = report.createTest("Verify time difference");
            LoginPage loginPage=new LoginPage();
            Calendar_Events_Page calendar_events_page=new Calendar_Events_Page();

            loginPage.login();
            calendar_events_page.navigateto("Activities","Calendar Events");
            calendar_events_page.clickToCreateCalendarEvent();

            String startTime=calendar_events_page.getStartTime();
            String endTime=calendar_events_page.getEndTime();
            String format = "h:mm a";//format 5:15 AM for example

            long actual = DateTimeUtilities.getTimeDifference(startTime, endTime, format);

            Assert.assertEquals(actual, 1, "Time difference is not correct");
            test.pass("Time difference verified");
        }



        @Test
        public void verifyColumnNamesTest(){
            test = report.createTest("Verify column names");
            LoginPage loginPage=new LoginPage();
            Calendar_Events_Page calendar_events_page=new Calendar_Events_Page();

            loginPage.login();
            calendar_events_page.navigateto("Activities", "Calendar Events");
            List<String> expected = Arrays.asList("TITLE", "CALENDAR", "START", "END", "RECURRENT", "RECURRENCE", "INVITATION STATUS");
            Assert.assertEquals(calendar_events_page.getColumnNames(), expected);
            test.pass("Column names verified");
    }

    @Test(dataProvider = "calendarEvents")
    public void createCalendarEventTest(String title, String description) {
        //if you have more one test, and 1st pass but others failing,
        //you are getting session id is null exception
        //because driver object was not initialized in time
        //just create page objects inside a test
        LoginPage loginPage = new LoginPage();
         Calendar_Events_Page calendarEventsPage = new Calendar_Events_Page();

        //only for extent report. To create a test in html report
        test = report.createTest("Create calendar event for " + title);
        loginPage.login();
        calendarEventsPage.navigateto("Activities", "Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();
        calendarEventsPage.enterCalendarEventTitle(title);
        calendarEventsPage.enterCalendarEventDescription(description);
        calendarEventsPage.clickOnSaveAndClose();

        //verify that calendar event info is correct
        Assert.assertEquals(calendarEventsPage.getGeneralInfoDescriptionText(), description);
        Assert.assertEquals(calendarEventsPage.getGeneralInfoTitleText(), title);

        //for extent report. specify that test passed in report (if all assertions passed)
        test.pass("Calendar event was created successfully!");
    }
    @DataProvider
    public Object[][] calendarEvents() {
        return new Object[][]{
                {"Daily stand-up", "Scrum meeting to provide updates"},
                {"Sprint Review",   "Scrum meeting where team discussing previous sprint"},
                {"Sprint Planning", "Scrum meeting where team discussing backlog for following sprint"}
        };

    }


}
