package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CheckoutCompletePage extends BasePage{

    public CheckoutCompletePage(WebDriver driver) {
       super(driver);
    }

    @FindBy(id = "back-to-products")
    protected WebElement backHomeBtn;

    @FindBy(id = "checkout_complete_container")
    protected WebElement orderConfirmationMessage;

    public void verifyOrderConfirmation(){
        Assert.assertTrue(orderConfirmationMessage.isDisplayed());
    }

    public void clickBackHome(){
        Assert.assertTrue(backHomeBtn.isEnabled());
        backHomeBtn.click();
    }
}