package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class idLocatorTest {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //maximize the browser
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        //click the dont click button
        WebElement dontClickButton = driver.findElement(By.id("disappearing_button"));
        //clicking button
        dontClickButton.click();

       /* WebElement button4 = driver.findElement(By.id("three_button"));

        button4.click();
        ID  SOMETIMES CHANGEABLE
        */


    }

}
