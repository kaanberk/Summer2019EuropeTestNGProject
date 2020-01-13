package com.cybertek.tests.day17_ddf;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFWithDataProvider {

    @DataProvider
    public Object[][] testData(){
        String data[][] ={
                {"GoT","9"},
                {"HIMYM","9"},
                {"Friends","10"},
                {"Breaking Bad","9"},
                {"Big Bang Theory","9"},
                {"Chernobyl","9"}
        };
        return data;
    }


    //get the data from data provider and pass as an argument
    @Test(dataProvider = "testData")
    public void test1(String tvshow,String rating){

        System.out.println("TvShow: "+tvshow+" has rating " +rating);
    }
}
