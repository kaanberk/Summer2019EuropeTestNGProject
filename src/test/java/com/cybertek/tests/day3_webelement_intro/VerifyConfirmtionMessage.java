package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyConfirmtionMessage {
    /**
     *Verify confirmation message
     * 			open browser
     * 			go to http://practice.cybertekschool.com/forgot_passwordLinks to an external site.
     * 			enter any email
     * 			verify that email is displayed in the input box
     * 			click on Retrieve password
     * 			verify that confirmation message says 'Your e-mail's been sent!'
     *
     */

    public static void main(String[] args) throws InterruptedException {

        //open browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //navigate to website
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //enter any email
        WebElement emailInputbox = driver.findElement(By.name("email"));

        String expectedemail = "test@gmail.com";

        //send expected email
        emailInputbox.sendKeys(expectedemail);

        //verify that email is displayed in the input box
        //getting txt from webelements
        //getText() --> get text from web element %99
        //getAttribute() --> get value of attributes --> for the input box
        String actualEmail = emailInputbox.getAttribute("value");

        if (expectedemail.equals(actualEmail)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("actualEmail = " + actualEmail);
            System.out.println("expectedemail = " + expectedemail);
        }

        //locating rerievePasswordButton using id attribute
        WebElement retrievePasswordButiin = driver.findElement(By.id("form_submit"));
        //clicking webelement
        retrievePasswordButiin.click();

        String expectedMessage = "Your e-mail's been sent!";
        WebElement messageElement = driver.findElement(By.name("confirmation_message"));

        String actualMessage = messageElement.getText();

        if (expectedMessage.equals(actualMessage)){
            System.out.println("Test 2: PASS");
        }else {
            System.out.println("Test 2: FAIL");
            System.out.println("actualMessage = " + actualMessage);
            System.out.println("expectedMessage = " + expectedMessage);
        }

        //close the browser
        driver.quit();

    }
}
