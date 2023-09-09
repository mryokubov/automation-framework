package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "login_logo")
    protected WebElement logo;

    @FindBy(id = "user-name")
    protected WebElement usernameInput;

    @FindBy(id = "password")
    protected WebElement passwordInput;

    @FindBy(id = "login-button")
    protected WebElement loginBtn;

    @FindBy(xpath = "//h3[@data-test='error']")
    protected WebElement loginError;

    public void verifyUserIsOnLoginPage(){
        Assert.assertTrue(loginBtn.isDisplayed());
    }

    public void login(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        Assert.assertTrue(loginBtn.isEnabled());
        loginBtn.click();
    }

    public void verifyLoginError(){
        Assert.assertTrue(loginError.isDisplayed());
    }



}
