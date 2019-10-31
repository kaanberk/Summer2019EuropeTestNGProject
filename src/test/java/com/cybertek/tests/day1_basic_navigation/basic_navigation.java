package com.cybertek.tests.day1_basic_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class basic_navigation {
    public static void main(String[] args) {

        //I need the first two sentences(13-16) for work with selenium

        //We have to setup webdriver based on the browser that we gonna use
        WebDriverManager.chromedriver().setup();

        //Creating object for using selenium driver
        WebDriver driver = new ChromeDriver();

        //Open browser
        driver.get("https://www.amazon.com");

        //Get the title and print it
        System.out.println(driver.getTitle());
    }
}
