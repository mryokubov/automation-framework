package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,  this);
    }

    @FindBy(className = "app_logo")
    protected WebElement mainHeader;

    @FindBy(className = "title")
    protected WebElement secondaryHeader;

    @FindBy(id = "shopping_cart_container")
    protected WebElement cart;

    @FindBy(id = "react-burger-menu-btn")
    protected WebElement menuIcon;

    @FindBy(id = "inventory_sidebar_link")
    protected WebElement allItemsLink;

    @FindBy(id = "about_sidebar_link")
    protected WebElement aboutLink;

    @FindBy(id = "logout_sidebar_link")
    protected WebElement logoutLink;

    @FindBy(id = "reset_sidebar_link")
    protected WebElement resetAppStateLink;

    @FindBy(className = "shopping_cart_badge")
    protected WebElement shoppingCartQuantity;

    @FindBy(className = "shopping_cart_link")
    protected WebElement shoppingCart;

    public void logout() throws InterruptedException {
        menuIcon.click();
        Thread.sleep(500);
        logoutLink.click();
    }

    public void resetAppState() throws InterruptedException {
        menuIcon.click();
        Thread.sleep(500);
        resetAppStateLink.click();
    }

    public void clickAbout() throws InterruptedException {
        menuIcon.click();
        Thread.sleep(500);
        aboutLink.click();
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Sauce Labs: Cross Browser Testing, Selenium Testing & Mobile Testing"));
        driver.navigate().back();
    }

    public void clickAllItems() throws InterruptedException {
        menuIcon.click();
        Thread.sleep(500);
        allItemsLink.click();
    }

    public void verifyCartQuantity(int quantity){

        String cartQuantity = shoppingCart.getText().trim();
        if (!cartQuantity.isEmpty()){
            int actualQuantity = Integer.parseInt(cartQuantity);
            Assert.assertEquals(actualQuantity, quantity);
        }else{
            Assert.assertTrue(true);
        }
    }

}
