package com.academy.techcenture.end2end;

import com.academy.techcenture.base.BaseTest;
import com.academy.techcenture.pages.LoginPage;
import com.academy.techcenture.pages.ProductsPage;
import org.testng.annotations.Test;
import static com.academy.techcenture.constants.Constants.*;

public class SwagLabsFilterTest extends BaseTest {

    @Test
    public void filterAtoZ() throws InterruptedException {
        extentTest = reports.startTest("Swag Labs filter A to Z Test");

        String[] filteredItems = {"Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt",
                "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)"};

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        loginPage.verifyUserIsOnLoginPage();
        loginPage.login(USERNAME, PASSWORD);
        productsPage.verifyUserIsOnProductsPage();
        productsPage.filter(FILTER_A_TO_Z);
        productsPage.verifyFilterProducts(filteredItems);
        productsPage.logout();
    }

    @Test
    public void filterZtoA() throws InterruptedException {
        extentTest = reports.startTest("Swag Labs filter Z to A Test");

        String[] filteredItems = {"Test.allTheThings() T-Shirt (Red)", "Sauce Labs Onesie", "Sauce Labs Fleece Jacket",
                "Sauce Labs Bolt T-Shirt", "Sauce Labs Bike Light",  "Sauce Labs Backpack"};

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        loginPage.verifyUserIsOnLoginPage();
        loginPage.login(USERNAME, PASSWORD);
        productsPage.verifyUserIsOnProductsPage();
        productsPage.filter(FILTER_Z_TO_A);
        productsPage.verifyFilterProducts(filteredItems);
        productsPage.logout();
    }

    @Test
    public void filterLowtoHigh() throws InterruptedException {
        extentTest = reports.startTest("Swag Labs filter Low to High Test");

        String[] filteredItems = {"Sauce Labs Onesie", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt",
                "Test.allTheThings() T-Shirt (Red)", "Sauce Labs Backpack", "Sauce Labs Fleece Jacket"};

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        loginPage.verifyUserIsOnLoginPage();
        loginPage.login(USERNAME, PASSWORD);
        productsPage.verifyUserIsOnProductsPage();
        productsPage.filter(FILTER_LOW_TO_HIGH);
        productsPage.verifyFilterProducts(filteredItems);
        productsPage.logout();
    }

    @Test
    public void filterHightoLow() throws InterruptedException {
        extentTest = reports.startTest("Swag Labs filter High to Low Test");

        String[] filteredItems = {"Sauce Labs Fleece Jacket", "Sauce Labs Backpack", "Sauce Labs Bolt T-Shirt", "Test.allTheThings() T-Shirt (Red)",
                "Sauce Labs Bike Light","Sauce Labs Onesie"};

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        loginPage.verifyUserIsOnLoginPage();
        loginPage.login(USERNAME, PASSWORD);
        productsPage.verifyUserIsOnProductsPage();
        productsPage.filter(FILTER_HIGH_TO_LOW);
        productsPage.verifyFilterProducts(filteredItems);
        productsPage.logout();
    }
}