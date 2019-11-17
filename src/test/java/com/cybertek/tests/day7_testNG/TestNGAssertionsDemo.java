package com.cybertek.tests.day7_testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {

    @Test
    public void test1(){
        System.out.println("First Assertion");
        Assert.assertEquals(1,1);

        System.out.println("Second Assertion");
        Assert.assertEquals("title","title");

        System.out.println("after second assertion");
    }

    @Test
    public void test2(){
        //verify that title starts with 'C'
        String actualTitle = "Cybertek";
        String expectedTitleBegining = "B";

        Assert.assertTrue(actualTitle.startsWith(expectedTitleBegining),"Verify that title starts with 'C' ");

        //TASK
        //Verify that email includes @ sign
        Assert.assertTrue("kaan@gmail.com".contains("@"),"Verify @ sign in the email");
    }

    @Test
    public void test3(){

        Assert.assertNotEquals("one","two","one should be equal to two");
    }

    @Test
    public void test4(){
        Assert.assertFalse(1<0);

    }


}
