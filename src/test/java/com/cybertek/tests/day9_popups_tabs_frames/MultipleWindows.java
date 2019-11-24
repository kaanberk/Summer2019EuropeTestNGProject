package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(3500);
        driver.quit();
    }

    @Test
    public void switchWindowsTest(){
        driver.get("http://practice.cybertekschool.com/windows");

        System.out.println("NBefore clicking the link: "+driver.getCurrentUrl());

        //Clicking click here link
        driver.findElement(By.linkText("Click Here")).click();

        System.out.println("After clicking the link: "+driver.getCurrentUrl());
        //code for switching windows , we have to pass handle
        //driver.switchTo().window()
        String currentWindowHandle = driver.getWindowHandle();
        System.out.println("currentWindowHandle = " + currentWindowHandle);
        //after this line, our purpose is switching to new window

        //Set is just like arraylist but without duplicate values
        Set<String> windowHandles = driver.getWindowHandles();
        //how many different handles it is keeping
        System.out.println(windowHandles.size());
        //our problem is how can we get new window handle from set of handles.There is no index.
        //loop through all handles inside the Set of handles
        for (String handle : windowHandles) {
            //checking handle is not equal to current page
            if(!currentWindowHandle.equals(handle)){
                //switching to new window
                driver.switchTo().window(handle);
            }
        }
        System.out.println("After switching "+driver.getTitle());


    }
}