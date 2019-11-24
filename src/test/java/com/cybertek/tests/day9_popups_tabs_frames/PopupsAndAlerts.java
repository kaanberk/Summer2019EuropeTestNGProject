package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupsAndAlerts {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(3500);
        driver.quit();
    }

    @Test
    public void test1(){
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");

        //locationg and clicking destroy button
        driver.findElement(By.xpath("//*[text()='Destroy the World']")).click();
        //locating No button and clicking it
        driver.findElement(By.xpath("//*[text()='No']")).click();
    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        //Click for JS Alert
        driver.findElement(By.xpath("//button[1]")).click();
        //Controlling alert using with Alert Class
        Alert alert = driver.switchTo().alert();
        //accept alert -->clicking ok in the alert
        alert.accept();

        //clicking JS Confirm
        driver.findElement(By.xpath("//button[2]")).click();
        //clicking to x to close, selecting no/cancel
        alert.dismiss();

        //clicking JS Prompt
        driver.findElement(By.xpath("//button[3]")).click();
        //sendKeys(); --> send some keys
        alert.sendKeys("Hello World");
        alert.accept();
    }
}
