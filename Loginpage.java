package com.coe.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(id = "username")  // change as per actual site
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "loginBtn")
    public WebElement loginButton;

    public void login(String user, String pass) {
        username.sendKeys(user);
        password.sendKeys(pass);
        loginButton.click();
    }
}
