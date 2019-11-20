package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DisplayDemo {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement usernameInput = driver.findElement(By.id("username"));
        //.isDisplayed() --> if the element is in the html code but not displayed
        //it will return false, if displayed it will return true
        System.out.println(usernameInput.isDisplayed());

        WebElement startButton = driver.findElement(By.xpath("//button[contains(text(),'')][1]"));
        startButton.click();

        Thread.sleep(5000);
        System.out.println(usernameInput.isDisplayed());
        usernameInput.sendKeys("kaanberk");


        Thread.sleep(2150);
        driver.quit();

    }
}
