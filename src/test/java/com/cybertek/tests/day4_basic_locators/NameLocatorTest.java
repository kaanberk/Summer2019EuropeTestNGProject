package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NameLocatorTest {

    public static void main(String[] args) throws InterruptedException {

        //open browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        //navigate to website
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullnameInput = driver.findElement(By.name("full_name"));
        fullnameInput.sendKeys("Mike Smith");

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("smithmike00@gmail.com");

        WebElement signupButton = driver.findElement(By.name("wooden_spoon"));
        signupButton.click();

        //Thread.sleep(3000);
        //driver.quit();
        //verify that message is same
        String expectedMessage = "Thank you for signing up. Click the button below to return to the home page.";

        WebElement messageElement = driver.findElement(By.name("signup_message"));
        String actualMessage = messageElement.getText();

        if(expectedMessage.equals(actualMessage)){
            System.out.println("PASS");
        }else {
            System.out.println("Fail");
            System.out.println("actualMessage = " + actualMessage);
            System.out.println("expectedMessage = " + expectedMessage);
        }

        Thread.sleep(3000);
        driver.quit();




    }
}
