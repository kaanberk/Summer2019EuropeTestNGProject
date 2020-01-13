package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkTextAndPartialText {

    public static void main(String[] args) throws InterruptedException {
        //open browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        //navigate to website
        driver.get("http://practice.cybertekschool.com/dynamic_loading");
        //link text
//        WebElement link3 = driver.findElement(By.linkText("Example 3: Element on page that is hidden and become visible after 5 seconds"));
//        link3.click();

//        lazy WAY
//        driver.findElement(By.linkText("home")).click();

        //partial link text
        WebElement link6 = driver.findElement(By.partialLinkText("Example 6"));
        link6.click();

        Thread.sleep(2500);
        driver.quit();


    }
}
