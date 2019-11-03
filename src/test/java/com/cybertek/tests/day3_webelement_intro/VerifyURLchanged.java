package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyURLchanged {
    /**
     *Verify URL changed
     * 			open browser
     * 			go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.
     * 			enter any email
     * 			click on Retrieve password
     * 			verify that url changed to http://practice.cybertekschool.com/email_sent
     */

    public static void main(String[] args) throws InterruptedException {

        //open the chrome
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //go to http://practice.cybertekschool.com/forgot_password links to an external site
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //enter any email
        WebElement emailInput = driver.findElement(By.name("email"));

        //sendKeys() -->  send keyboard actions to webelement / enters given text
        emailInput.sendKeys("email@gmail.com");

        //locate to password retrieve button
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));

        retrievePasswordButton.click();

        String expectedUrl = "http://practice.cybertekschool.com/email_sent";
        String actualURL = driver.getCurrentUrl();
        if (expectedUrl.equals(actualURL)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("actualURL = " + actualURL);
            System.out.println("expectedURL = "+expectedUrl);
        }

        Thread.sleep(2000);
        driver.quit();
    }
}
