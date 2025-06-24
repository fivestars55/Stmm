package com.coe.test;

import org.testng.annotations.*;
import org.openqa.selenium.support.PageFactory;
import com.coe.script.SuperClass;
import com.coe.pom.LoginPage;

public class LoginTest extends SuperClass {

    @BeforeClass
    public void open() {
        launch();
    }

    @DataProvider
    public Object[][] getData() throws Exception {
        return readExcel("Credentials.xlsx");
    }

    @Test(dataProvider = "getData")
    public void test(String user, String pass) {
        PageFactory.initElements(driver, LoginPage.class).login(user, pass);
    }

    @AfterClass
    public void close() {
        driver.quit();
    }
}
