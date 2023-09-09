package com.academy.techcenture.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import java.util.List;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "continue-shopping")
    protected WebElement continueShoppingBtn;

    @FindBy(id = "checkout")
    protected WebElement checkoutBtn;

    public void verifyProductInCart(){
        int quantity = 0;
        if (shoppingCartQuantity.isDisplayed()){
            quantity = Integer.parseInt(shoppingCartQuantity.getText().trim());
        }
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='cart_item']"));
        Assert.assertEquals(quantity, products.size());

    }

    public void checkout(){
        Assert.assertTrue(checkoutBtn.isEnabled());
        checkoutBtn.click();
    }

    public void continueShopping(){
        Assert.assertTrue(continueShoppingBtn.isEnabled());
        continueShoppingBtn.click();
    }

}
