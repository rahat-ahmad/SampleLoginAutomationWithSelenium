package com.sampleloginautomation.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LoginModel {

    public WebElement userName;
    public WebElement password;
    public WebElement loginButton;
    public List<String> credentials;
    public WebDriver driver;
    public WebDriverWait wait;

    public LoginModel() {
    }

    public LoginModel(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public List<String> getCredentials() {
        return credentials;
    }

    public void setCredentials(List<String> credentials) {

        this.credentials = credentials;
    }

    public WebElement getUserName() {
        return userName;
    }

    public void setUserName(WebElement userName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        this.userName = userName;
    }

    public WebElement getPassword() {
        return password;
    }

    public void setPassword(WebElement password) {
        this.password = password;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(WebElement loginButton) {
        this.loginButton = loginButton;
    }
}
