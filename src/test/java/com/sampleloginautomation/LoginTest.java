package com.sampleloginautomation;

import com.sampleloginautomation.model.LoginModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import sampleloginautomation.util.WebDriverInitialization;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;

public class LoginTest {

    WebDriver driver;
    WebDriverWait wait;
    LoginModel login;

    @BeforeMethod()
    public void beforeClass() throws FileNotFoundException {
        driver = new WebDriverInitialization().getChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://www.facebook.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        login = new LoginModel(driver,wait);

    }

    @Test
//    @Ignore
    public void loginWithValidCredentials(){
        List<String> credentials = login.getCredentials();
        login.getUserName().sendKeys(credentials.get(0).trim());
        login.getPassword().sendKeys(credentials.get(1).trim());
        login.getLoginButton().click();
        int length = driver.findElements(By.id("approvals_code")).size();
        Assert.assertTrue(length!=0);

    }

    @Test
    public void loginWithInValidCredentials(){
        login.getUserName().sendKeys("test@gmail.com");
        login.getPassword().sendKeys("1234");
        login.getLoginButton().click();
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_box"))).getText().contains("Wrong credentials"));
    }

    @Test
    public void loginWithoutGivingCredentials(){
        login.getUserName().sendKeys("");
        login.getPassword().sendKeys("");
        login.getLoginButton().click();
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_box"))).getText().contains("Wrong credentials"));
    }

    @AfterMethod
    public void closeDriver(){
        driver.quit();
    }


}
