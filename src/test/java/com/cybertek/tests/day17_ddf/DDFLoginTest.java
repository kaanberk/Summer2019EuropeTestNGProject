package com.cybertek.tests.day17_ddf;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFLoginTest extends TestBase {

    @DataProvider
    public Object[][] userData(){
        //we read data from excel by using excelutil class
        ExcelUtil data = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx","QA3-short");
        //and we return the data without the first row as in two dimensional array
        String[][] dataArray = data.getDataArrayWithoutFirstRow();

        return dataArray;
    }

    @Test(dataProvider = "userData")
    public void loginTestDDF(String username,String password,String firstname,String lastname){
        extentLogger = report.createTest("Test "+ firstname+" "+lastname);

        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();

        String actualFirstname = dashboardPage.getUserName();
        String expectedFullname = firstname + " " + lastname;

        Assert.assertEquals(actualFirstname,expectedFullname,"Compare the usernames");


    }

}
