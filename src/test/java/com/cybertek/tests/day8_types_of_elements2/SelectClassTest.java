package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SelectClassTest {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");

        //1. Locate the dropdown with unique locator
        WebElement dropdownElement = driver.findElement(By.id("state"));
        //create Select object by passing the element as a constructor
        Select stateList = new Select(dropdownElement);
        //verify that first option is "Select a State"
        String expectedResult = "Select a State";
        String actualOption = stateList.getFirstSelectedOption().getText();
        System.out.println("actualOption = " + actualOption);
        Assert.assertEquals(actualOption,expectedResult,"Verify that first option is Select a State");

        //HOW TO SELECT OPTIONS FROM THE DROPDOWN
        //1. USING VISIBLE TEXT
        //selectByVisibleText("text") ---> selecting based on the visible text
        Thread.sleep(2100);
        stateList.selectByVisibleText("Texas");
        actualOption = stateList.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,"Texas");

        //2.USING INDEX NUMBER
        //total option -->52
        Thread.sleep(2000);
        stateList.selectByIndex(51);

        //3.USING VALUE
        Thread.sleep(2000);
        stateList.selectByValue("VA");
        System.out.println(stateList.getFirstSelectedOption().getText());

        /*
        getOptions(); ---> returns all the options of dropdown menu
        List<WebElement> options = stateList.getOptions();

        for (WebElement option : options) {
            System.out.println(option.getText());
        }
         */

        Thread.sleep(2056);
        driver.quit();
    }
}
