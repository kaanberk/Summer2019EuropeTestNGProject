package com.cybertek.tests.day13_properties_driver_testbase;

public class Singleton {

    //Singleton class will have private constructor
    //it means other class can not create object of this class
    private Singleton(){ }

    private static String str;

    public static String getInstance(){
        //if ste has no value. initialize it and return it
        if (str==null){
            System.out.println("str is null. assigning value to it");
            str = "somevalue";
        }else{
            //if it has value just return it
            System.out.println("it has value just return it");
        }

        return str;
    }
}
