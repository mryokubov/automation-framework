package com.academy.techcenture.end2end;

import com.academy.techcenture.base.BaseTest;
import com.academy.techcenture.pages.LoginPage;
import com.academy.techcenture.pages.ProductsPage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;
import static com.academy.techcenture.constants.Constants.*;

public class SwagLabsLoginTest extends BaseTest {

    @Test
    public void loginPositiveTest(){
        extentTest = reports.startTest("Swag Labs Login Positive Test");

        LoginPage loginPage = new LoginPage(driver);
        extentTest.log(LogStatus.INFO, "Created Login Page");
        ProductsPage productsPage = new ProductsPage(driver);
        extentTest.log(LogStatus.INFO, "Created Products Page");
        loginPage.verifyUserIsOnLoginPage();
        extentTest.log(LogStatus.PASS, "User navigated to Login Page successfully");
        loginPage.login(USERNAME, PASSWORD);
        extentTest.log(LogStatus.PASS, "User was able to login with valid credentials");
        productsPage.verifyUserIsOnProductsPage();
        extentTest.log(LogStatus.PASS, "User was successfully navigated to Products Page");
    }

    @Test(enabled = false)
    public void loginIncorrectCredentialsTest(){
        extentTest = reports.startTest("Swag Labs Login Negative Test (Incorrect Credentials)");
        LoginPage loginPage = new LoginPage(driver);
        extentTest.log(LogStatus.INFO, "Created Login Page");
        loginPage.verifyUserIsOnLoginPage();
        extentTest.log(LogStatus.PASS, "User navigated to Login Page successfully");
        loginPage.login(USERNAME, INCORRECT_PASSWORD);
        extentTest.log(LogStatus.INFO, "User tries to log in with incorrect password");
        loginPage.verifyLoginError();
        extentTest.log(LogStatus.PASS, "User was able to see error messages on the login page");
    }
    @Test(enabled = false)
    public void loginEmptyCredentialsTest(){
        extentTest = reports.startTest("Swag Labs Login Negative Test (Empty Credentials)");
        LoginPage loginPage = new LoginPage(driver);
        extentTest.log(LogStatus.INFO, "Created Login Page");
        loginPage.verifyUserIsOnLoginPage();
        extentTest.log(LogStatus.PASS, "User navigated to Login Page successfully");
        loginPage.login(EMPTY_CREDS, EMPTY_CREDS);
        extentTest.log(LogStatus.INFO, "User tries to log in with empty credentials");
        loginPage.verifyLoginError();
        extentTest.log(LogStatus.PASS, "User was able to see error messages on the login page");
    }

    @Test(enabled = false)
    public void testSomething(){
        System.out.println("This is a correct line of code");
        System.out.println("This is another correct line of code");
    }
}
