package com.cybertek.tests.day14_pom_test;

import com.cybertek.pages.BasePage;
import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase {

    /**Test Case
     * open browser
     * Login as a Driver
     * Verify that page subtitle is quick LaunchPad
     * Go to Activities --> Calender Events
     * Verify that page subtitle os Calender Events
     */

    @Test
    public void verifySubtitleTest(){
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        loginPage.login(username,password);

        DashboardPage dashboardPage = new DashboardPage();
        //actual subtitle
        String dashboardTitle = dashboardPage.getPageSubTitle();
        //expected subtitle
        String expectedSubtitle = "Quick Launchpad";
        //verify titles are matching
        Assert.assertEquals(dashboardTitle,expectedSubtitle);

        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        Assert.assertEquals(calendarEventsPage.getPageSubTitle(),"Calendar Events","verify that page subtitle is Calendar Events");

    }
}
