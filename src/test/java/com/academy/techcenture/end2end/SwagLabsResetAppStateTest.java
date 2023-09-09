package com.academy.techcenture.end2end;

import com.academy.techcenture.base.BaseTest;
import com.academy.techcenture.pages.LoginPage;
import com.academy.techcenture.pages.ProductDetailsPage;
import com.academy.techcenture.pages.ProductsPage;
import org.testng.annotations.Test;

import static com.academy.techcenture.constants.Constants.*;

public class SwagLabsResetAppStateTest extends BaseTest {

    @Test
    public void resetAppStateTest() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);

        loginPage.verifyUserIsOnLoginPage();
        loginPage.login(USERNAME, PASSWORD);
        productsPage.verifyUserIsOnProductsPage();

        productsPage.filter(FILTER_LOW_TO_HIGH);
        productsPage.selectFirstItem();
        productDetailsPage.addProductToCart();
        productDetailsPage.clickAllItems();

        productsPage.filter(FILTER_HIGH_TO_LOW);
        productsPage.selectFirstItem();
        productDetailsPage.addProductToCart();
        productDetailsPage.clickAllItems();

        productsPage.filter(FILTER_A_TO_Z);
        productsPage.selectFirstItem();
        productDetailsPage.addProductToCart();
        productDetailsPage.clickAllItems();

        productsPage.filter(FILTER_Z_TO_A);
        productsPage.selectFirstItem();
        productDetailsPage.addProductToCart();
        productDetailsPage.clickAllItems();
        productsPage.verifyCartQuantity(4);
        productsPage.resetAppState();
        productsPage.verifyCartQuantity(0);
    }

}
