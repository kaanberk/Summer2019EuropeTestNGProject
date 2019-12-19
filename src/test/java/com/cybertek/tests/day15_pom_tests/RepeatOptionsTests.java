package com.cybertek.tests.day15_pom_tests;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**     VERIFY RADIO BUTTONS
        Open browser
        Login as driver
        Go to Activities->Calendar Events
        Click on create calendar events
        Click on repeat
        Verify that repeat every days is checked
        Verify that repeat weekday is not checked
*/

public class RepeatOptionsTests extends TestBase {

    @Test
    public void RepeateRadioButtonTest(){
        //Login as driver
        LoginPage loginPage = new LoginPage();

        String username= ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        loginPage.login(username,password);

        //Go to Activities->Calendar Events
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities" , "Calendar Events");

        //Click on create calendar events
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
            //if you getting error
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEvent.click();

        //Click on repeat
        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();

        //Verify that repeat every days is checked
        Assert.assertTrue(createCalendarEventsPage.repeat.isSelected(),"Verify the repeat every day is selected");

        //Verify that repeat weekday is not checked
        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected(),"Verify the repeat weekday is not selected");

    }

    /**VERIFY REPEAT OPTIONS
     Open browser
     Login as driver
     Go to Activities->Calendar
     Click on create calendar events
     Click on repeat
     Verify that repat options are Daily, Weekly, Monthly,Yearly(in this order)
     */
    @Test
    public void verifyRepeateOptions(){
        //Login as driver
        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigurationReader.get("driver_username"),ConfigurationReader.get("driver_password"));

        //Go to Activities->Calendar
        new DashboardPage().navigateToModule("Activities", "Calendar Events");

        //Click on create calendar events
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEvent.click();

        //Click on repeat
        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();

        //Verify that repeat options are Daily, Weekly, Monthly,Yearly(in this order)
        List<String> expectedList = Arrays.asList("Daily","Weekly","Monthly","Yearly");
        List<WebElement> actualOptions = createCalendarEventsPage.repeatOptionsList().getOptions();

        List<String> actualList = BrowserUtils.getElementsText(actualOptions);
        Assert.assertEquals(actualList,expectedList,"compare the dropdown values");
    }


}
