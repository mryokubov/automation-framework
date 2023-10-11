package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
public class CheckoutOverviewPage extends BasePage{

    public CheckoutOverviewPage(WebDriver driver) {
      super(driver);
    }

    @FindBy(id = "cancel")
    protected WebElement cancelBtn;

    @FindBy(id = "finish")
    protected WebElement finishBtn;

    @FindBy(className = "summary_value_label")
    protected WebElement orderNumber;


    public void verifyOrder(){
        Assert.assertTrue(orderNumber.isDisplayed());
    }

    public void clickFinish(){
        Assert.assertTrue(finishBtn.isEnabled());
        finishBtn.click();
    }

    public void clickCancel(){
        Assert.assertTrue(cancelBtn.isEnabled());
        cancelBtn.click();
    }
}