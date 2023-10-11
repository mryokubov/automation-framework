package com.academy.techcenture.end2end;

import com.academy.techcenture.base.BaseTest;
import com.academy.techcenture.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.academy.techcenture.constants.Constants.*;

/**
 * This is our Test Class for Place Order functionality on Swaglabs
 * This class will contains both positive and negative scenarios
 */
public class SwagLabsPlaceOrderTest extends BaseTest {

    @Test
    public void placeOrderPositiveTest() throws InterruptedException {
        extentTest = reports.startTest("Swag Labs place order positive Test");

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage(driver);
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);

        loginPage.login(USERNAME, PASSWORD);
        productsPage.filter(FILTER_LOW_TO_HIGH);
        productsPage.selectFirstItem();
        productDetailsPage.verifyProduct();
        productDetailsPage.addProductToCart();
        productDetailsPage.goToCart();
        cartPage.verifyProductInCart();
        cartPage.checkout();
        checkoutInformationPage.enterCheckoutInformation(FIRSTNAME, LASTNAME, ZIP_CODE);
        checkoutInformationPage.clickContinue();
        checkoutOverviewPage.verifyOrder();
        checkoutOverviewPage.clickFinish();
        checkoutCompletePage.verifyOrderConfirmation();
        checkoutCompletePage.clickBackHome();
        productsPage.logout();
    }

    @Test
    public void placeOrderNegativeTest() throws InterruptedException {
        extentTest = reports.startTest("Swag Labs place order negative Test");

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage(driver);

        loginPage.login(USERNAME, PASSWORD);
        productsPage.filter(FILTER_LOW_TO_HIGH);
        productsPage.selectFirstItem();
        productDetailsPage.verifyProduct();
        productDetailsPage.addProductToCart();
        productDetailsPage.goToCart();
        cartPage.verifyProductInCart();
        cartPage.checkout();

        checkoutInformationPage.enterCheckoutInformation(EMPTY_CREDS, EMPTY_CREDS, EMPTY_CREDS);
        checkoutInformationPage.clickContinue();
        checkoutInformationPage.verifyError();
        checkoutInformationPage.clickCancel();
        cartPage.continueShopping();
        productDetailsPage.logout();

        Assert.assertEquals(45, 45, "jkfads");
    }

}
