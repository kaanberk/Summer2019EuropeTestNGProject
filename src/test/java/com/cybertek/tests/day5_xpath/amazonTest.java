package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class amazonTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.amazon.co.uk/");

        driver.manage().window().maximize();

        WebElement inputBox = driver.findElement(By.id("twotabsearchtextbox"));

        inputBox.sendKeys("iphone 7 case");

        WebElement searchButton = driver.findElement(By.xpath("//input[@type =\"submit\"]\n"));

        searchButton.click();

        Thread.sleep(2500);
        driver.quit();

    }

}
