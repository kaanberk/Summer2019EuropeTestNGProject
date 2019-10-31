package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDemo {
    public static void main(String[] args) throws InterruptedException {

        //setting up the browser
        WebDriverManager.chromedriver().setup();

        //import class CONTROL SPACE
        //selenium object
        WebDriver driver = new ChromeDriver();

        //navigatiion to website
        driver.get("https://www.amazon.com");

        //another way of opening website
        driver.navigate().to("https://www.facebook.com");

        //goes back to previous page
        driver.navigate().back();

        //goes forward after goes back
        driver.navigate().forward();

        //it stops the code working for written number (1 second = 1000 milli seconds)
        Thread.sleep(3000);

        //to refresh to page
        driver.navigate().refresh();


    }
}
