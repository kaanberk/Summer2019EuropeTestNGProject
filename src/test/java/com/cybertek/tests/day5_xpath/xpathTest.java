package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class xpathTest {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/multiple_buttons");
//        driver.get("http://practice.cybertekschool.com/sign_up");

        //Absolute Xpath
        WebElement homeLink = driver.findElement(By.xpath("/html/body/nav/ul/li/a"));

        //Relative Xpath
//        WebElement signUp = driver.findElement(By.xpath("//button[@name='wooden_spoon']"));

//        homeLink.click();
//        signUp.click();

    }
}
