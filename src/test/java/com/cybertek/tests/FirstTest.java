package com.cybertek.tests;

import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class FirstTest extends TestBase{

    @Test
    public void test1(){

        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigurationReader.get("salesmanager_username"),ConfigurationReader.get("salesmanager_password"));
        loginPage.loginBtn.click();



    }
}
