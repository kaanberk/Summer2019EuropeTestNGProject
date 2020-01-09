package com.cybertek.pages;


import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarEventsPage extends BasePage {

    public CalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;
    //VyTrack -> tescase1
    @FindBy(xpath = "//body[@class='desktop-version lang-en']/div[@id='page']/div[@class='app-page__content']/div[@class='app-page__main']/div[@id='central-panel']/div[@id='container']/div[@id='grid-calendar-event-grid-1604567828']/div[@class='oro-datagrid']/div[@class='other-scroll-container']/div[@class='grid-scrollable-container']/div[@class='grid-container']/table[@class='grid table-hover table table-bordered table-condensed']/tbody[@class='grid-body']/tr[19]/td[9]/div[1]/div[1]/a[1] ")
    public WebElement testerMeetingsDots;

    @FindBy(xpath = "//tr[19]//td[9]//div[1]//div[1]//ul[1]//li[1]//ul[1]//li[3]//a[1]//i[1]")
    public WebElement option1Dots;
    //VyTrack -> testcase2
    @FindBy(xpath = "//i[@class='fa-cog hide-text']")
    public WebElement grid;


}