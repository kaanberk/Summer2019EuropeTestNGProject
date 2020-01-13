package com.cybertek.tests.day7_testNG;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BeforeAndAfterTest {

    @Test
    public void test1(){
        System.out.println("This is test 1");

        //after each
        //close browser
    }

    @Test
    public void test2(){
        System.out.println("This is my test 2");
    }

    @BeforeMethod
    public void setUpMethod(){

        System.out.println("BEFORE METHOD");
        System.out.println("OPENING THE BROWSER");

        //-->begining of the each test
        //webdriver code
        //driver.get
        //some settings before test (maximize window --> based on requirements)

    }

    @AfterMethod
    public void tearDown(){
        System.out.println("AFTER METHOD");
        System.out.println("CLOSE BROWSER");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("BEFORE CLOSE CODE");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("AFTER CLASS CODE");
        System.out.println("REPORTING");
    }


}
