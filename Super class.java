package com.coe.script;

import java.io.*;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SuperClass {
    public static WebDriver driver;

    public void launch() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://example.com"); // change to your URL
    }

    public String[][] readExcel(String path) throws Exception {
        Workbook wb = WorkbookFactory.create(new FileInputStream(path));
        Sheet sheet = wb.getSheetAt(0);
        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(0).getLastCellNum();
        String[][] data = new String[rows][cols];
        for (int i = 1; i <= rows; i++)
            for (int j = 0; j < cols; j++)
                data[i-1][j] = sheet.getRow(i).getCell(j).toString();
        return data;
    }
}
