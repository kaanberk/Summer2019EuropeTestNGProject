package com.cybertek.tests.VyTrack.Test_Case4;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class TestCase extends TestBase {

 /**
    1.Go to “https://qa1.vytrack.com/"
    2.Login as a store manager
    3.Navigate to “Activities -> Calendar Events”
    4.Hover on three dots “...” for “Testers meeting” calendar event
    5.Verify that “view”, “edit” and “delete” options are available
*/
    @Test
    public void test1() throws InterruptedException {
        //Login as a Store Manager
        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigurationReader.get("storemanager_username"),ConfigurationReader.get("storemanager_password"));

        //Navigate to Activities -> Calendar Events
        new DashboardPage().waitUntilLoaderScreenDisappear();
        new DashboardPage().navigateToModule("Activities","Calendar Events");

        //Hover on three dots for Testers meeting calendar event
        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        WebElement dots = driver.findElement(By.cssSelector(" body.desktop-version.lang-en:nth-child(2) div.app-page:nth-child(2) div.app-page__content div.app-page__main div.app-page__central-panel div.scrollable-container:nth-child(3) div.disable-scroll:nth-child(3) div.oro-datagrid.floatThead-fixed div.other-scroll-container:nth-child(2) div.grid-scrollable-container div.grid-container table.grid.table-hover.table.table-bordered.table-condensed tbody.grid-body:nth-child(4) tr.grid-row.row-click-action:nth-child(19) td.action-cell.grid-cell.grid-body-cell:nth-child(9) div.more-bar-holder div.dropdown > a.dropdown-toggle"));
        actions.moveToElement(dots).perform();

        //Verify that options are available
        WebElement option1 = driver.findElement(By.xpath("//tr[19]//td[9]//div[1]//div[1]//ul[1]//li[1]//ul[1]//li[3]//a[1]//i[1]"));

    }
/**
    1.Go to “https://qa1.vytrack.com/"
    // 2.Login as a store manager
    // 3.Navigate to “Activities -> Calendar Events”
    // 4.Click on “Grid Options” button
    // 5.Deselect all options except “Title”
    // 6.Verify that “Title” column still displayed
*/
    @Test
    public void test2(){
        //Login as a Store Manager
        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigurationReader.get("storemanager_username"),ConfigurationReader.get("storemanager_password"));

        //Navigate to Activities -> Calendar Events
        new DashboardPage().waitUntilLoaderScreenDisappear();
        new DashboardPage().navigateToModule("Activities","Calendar Events");

        //click on grid option
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.grid.click();

        //Deselect all option except title
        for (int i = 1; i < 7 ; i++) {
            String boxpath = "//input[@id='column-c11"+i+"']";
            System.out.println("boxpath = " + boxpath);
            WebElement box = driver.findElement(By.xpath(boxpath));
            System.out.println("box.isSelected() = " + box.isSelected());
            Assert.assertFalse(box.isSelected(),"Verify that box is not selected");
        }
       WebElement box1 = driver.findElement(By.cssSelector("#column-c111"));
       box1.click();
        System.out.println("box1.isSelected() = " + box1.isSelected());

    }

    /**
    1.Go to “https://qa1.vytrack.com/"
    2.Login as a store manager
    3.Navigate to “Activities -> Calendar Events”
    4.Click on “Create Calendar Event” button
    5.Expand “Save And Close” menu
    6.Verify that “Save And Close”, “Save And New” and “Save” options are available
    */
    @Test
    public void test3() throws InterruptedException {
        //Login as a Store Manager
        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigurationReader.get("storemanager_username"),ConfigurationReader.get("storemanager_password"));

        //Navigate to Activities -> Calendar Events
        new DashboardPage().waitUntilLoaderScreenDisappear();
        new DashboardPage().navigateToModule("Activities","Calendar Events");

        //Click on Create Calendar Event button
        new CalendarEventsPage().waitUntilLoaderScreenDisappear();
        new CalendarEventsPage().createCalendarEvent.click();

        //Expand save and close
        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        WebElement dropdown = driver.findElement(By.xpath("//a[@class='btn-success btn dropdown-toggle']"));
        Thread.sleep(2000);
        dropdown.click();

        //Verify that "Save And Close", "Save And New" and "Save" options are available
        String SaveAndClose = "Save And Close";
        String SaveAndNew = "Save And New";
        String Save = "Save";

        WebElement option1 = driver.findElement(By.xpath("//button[@class='action-button dropdown-item']"));
        Assert.assertEquals(option1.getText(),SaveAndClose,"Verify that text is Save and Close");

        WebElement option2 = driver.findElement(By.xpath("//button[contains(text(),'Save and New')]"));
        Assert.assertEquals(option2.getText(),SaveAndNew,"Verify the text is Save and New");

        WebElement option3 = driver.findElement(By.xpath("//li[3]//button[1]"));
        Assert.assertEquals(option3.getText(),Save,"Verify the text is Save");
    }

    /**
    1.Go to “https://qa1.vytrack.com/"
    2.Login as a store manager
    3.Navigate to “Activities -> Calendar Events”
    4.Click on “Create Calendar Event” button
    5.Then, click on “Cancel” button
    6.Verify that “All Calendar Events” page subtitle is displayed
    */
    @Test
    public void test4() throws InterruptedException {
        //Login as a Store Manager
        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigurationReader.get("storemanager_username"),ConfigurationReader.get("storemanager_password"));

        //Navigate to Activities -> Calendar Events
        new DashboardPage().waitUntilLoaderScreenDisappear();
        new DashboardPage().navigateToModule("Activities","Calendar Events");

        //Click on Create Calendar Event button
        new CalendarEventsPage().waitUntilLoaderScreenDisappear();
        new CalendarEventsPage().createCalendarEvent.click();

        //Click on "Cancel" button
        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        createCalendarEventsPage.waitUntilLoaderScreenDisappear();
        createCalendarEventsPage.cancel.click();

        //Verify that "All Calendar Events" page subtitle is displayed
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        String title = calendarEventsPage.getPageSubTitle();

        Assert.assertEquals(title,"All Calendar Events","Verify the subtitle is displayed");

    }
    /**
    1.Go to “https://qa1.vytrack.com/"
    2.Login as a store manager
    3.Navigate to “Activities -> Calendar Events”
    4.Click on “Create Calendar Event” button
    5.Verify that difference between end and start time is exactly 1 hour
    */

    @Test
    public void test5() throws InterruptedException {
        //Login as a Store Manager
        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigurationReader.get("storemanager_username"),ConfigurationReader.get("storemanager_password"));

        //Navigate to Activities -> Calendar Events
        new DashboardPage().waitUntilLoaderScreenDisappear();
        new DashboardPage().navigateToModule("Activities","Calendar Events");

        //Click on Create Calendar Event button
        new CalendarEventsPage().waitUntilLoaderScreenDisappear();
        new CalendarEventsPage().createCalendarEvent.click();

        //Verify that difference between end and start time is exactly 1 hour
        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        System.out.println("createCalendarEventsPage.startTime.getText() = " + createCalendarEventsPage.startTime.getText());
    }
}
