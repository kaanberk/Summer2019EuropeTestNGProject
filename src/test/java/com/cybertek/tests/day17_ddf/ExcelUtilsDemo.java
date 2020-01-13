package com.cybertek.tests.day17_ddf;

import com.cybertek.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilsDemo {
    @Test
    public void readExcelFile(){

        //create an object from ExcelUtil
        //it accepts two argument
        //Argument 1: location of the file(path)
        //Argument 2: sheet that we want to open (sheetName)
        ExcelUtil qa3short = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx","QA3-short");

        //How many rows in the sheet
        System.out.println("Row count: " + qa3short.rowCount());

        //How many columns in the sheet
        System.out.println("Columns count: " + qa3short.columnCount());

        //Get the column names
        System.out.println("Column names: " + qa3short.getColumnsNames());

        //Get all data in list of maps
        //each map representing one column
        List<Map<String, String>> dataList = qa3short.getDataList();

        //print them one by one for each row
        for (Map<String, String> oneRow : dataList) {
            System.out.println(oneRow);
        }



        //get all data in 2d array
        String[][] dataArray = qa3short.getDataArray();

        //print the array
        System.out.println(Arrays.deepToString(dataArray));


    }
}