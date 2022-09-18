package com.sampleloginautomation.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sampleloginautomation.util.CredentialsFromFile;

import java.io.FileNotFoundException;
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

    public LoginModel(WebDriver driver, WebDriverWait wait) throws FileNotFoundException {
        this.driver = driver;
        this.wait = wait;
        this.setLoginButton();
        this.setUserName();
        this.setPassword();
        this.setCredentials();
    }

    public List<String> getCredentials() {
        return credentials;
    }

    public void setCredentials() throws FileNotFoundException {
        CredentialsFromFile loginCredentials = new CredentialsFromFile();
        this.credentials = loginCredentials.getCredentials();
    }

    public WebElement getUserName() {
        return userName;
    }

    public void setUserName() {
        this.userName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
    }

    public WebElement getPassword() {
        return password;
    }

    public void setPassword() {
        this.password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pass")));
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public void setLoginButton() {
        this.loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
    }
}
