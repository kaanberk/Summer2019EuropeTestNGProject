package com.cybertek.tests.VyTrack;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class login_positiveTest {

    public static void main(String[] args) throws InterruptedException {
        loginTest("https://qa1.vytrack.com/user/login");
    }

    public static void loginTest (String address) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get(address);

        WebElement usernameInput = driver.findElement(By.id("prependedInput"));

        usernameInput.sendKeys("user4");

        WebElement passwordInput = driver.findElement(By.name("_password"));

        passwordInput.sendKeys("UserUser123");

        WebElement loginButton = driver.findElement(By.name("_submit"));

        loginButton.click();

        String actualLink = driver.getCurrentUrl();
        String expectedLink = "https://qa1.vytrack.com/";

        if(expectedLink.equals(actualLink)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("expectedLink = " + expectedLink);
            System.out.println("actualLink = " + actualLink);
        }

        Thread.sleep(2500);
        driver.quit();


    }
}
