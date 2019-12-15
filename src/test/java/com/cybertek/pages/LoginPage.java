package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }

/*    Examples of using @FindAll and @FindBys
   @FindAll({     --> gives us option to use multiple locators, if at least ano of them is matching it will work
            @FindBy(id ="prependedInput");
            @FindBy(xpath = "_username");
    })

    @FindBys({      --> if all locators matching with element then it will return it AND logic applies
            @FindBy(id ="prependedInput");
            @FindBy(xpath = "_username");
    )}
*/
    public WebElement username2;

    //same with driver,findElement(By.id("prependedInput"));
    @FindBy(id = "prependedInput")
    public WebElement usernameInput;

    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    @FindBy(id = "_submit")
    public WebElement loginBtn;

    public void login(String usernameStr,String passwordStr){

        usernameInput.sendKeys(usernameStr);
        passwordInput.sendKeys(passwordStr);
        loginBtn.click();
    }


}
