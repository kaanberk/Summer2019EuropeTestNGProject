package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClassLocatorTest {

    public static void main(String[] args) throws InterruptedException {

        //open browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        //navigate to website
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement homeLink = driver.findElement(By.className("nav-link"));
        homeLink.click();

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement printTitle = driver.findElement(By.className("h3"));
        System.out.println(printTitle.getText());

        //Lazy WAY
        System.out.println(driver.findElement(By.className("h3")).getText());

        //note : if there is a space in class name

       Thread.sleep(2500);
       driver.quit();


    }
}
