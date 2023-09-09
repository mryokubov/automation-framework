package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CheckoutInformationPage extends BasePage{

    public CheckoutInformationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "first-name")
    protected WebElement firstNameInput;

    @FindBy(id = "last-name")
    protected WebElement lastNameInput;

    @FindBy(id = "postal-code")
    protected WebElement zipCodeInput;

    @FindBy(id = "cancel")
    protected WebElement cancelBtn;

    @FindBy(id = "continue")
    protected WebElement continueBtn;

    @FindBy(xpath = "//h3[@data-test='error']")
    protected WebElement errorMsg;

    public void enterCheckoutInformation(String firstName, String lastName, String zipCode){
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        zipCodeInput.sendKeys(zipCode);
    }

    public void clickContinue(){
        Assert.assertTrue(continueBtn.isEnabled());
        continueBtn.click();
    }

    public void clickCancel(){
        Assert.assertTrue(cancelBtn.isEnabled());
        cancelBtn.click();
    }

    public void verifyError(){
        Assert.assertTrue(errorMsg.isDisplayed());
    }
}
