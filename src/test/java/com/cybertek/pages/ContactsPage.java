package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsPage extends BasePage{

    //we don`t need to create constructor and use PageFactory class here,
    //since we are extending from basepage

    //if you are trying to come up dynamic xpath you cannot use @FindBy
    @FindBy(xpath ="//td[contains(text(),'mbrackstone9@example.com’)][@data-column-label=‘Email’]")
    public WebElement email;

    //create a method that accepts email as a String, and returns webelement based on that email.

    public WebElement getContactEmail(String email){
        String emailXpath = "//td[contains(text(),'"+email+"')][@data-column-label='Email']";
        return Driver.get().findElement(By.xpath(emailXpath));
    }
}
