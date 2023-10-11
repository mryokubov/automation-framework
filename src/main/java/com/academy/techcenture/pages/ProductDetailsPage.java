package com.academy.techcenture.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProductDetailsPage extends BasePage {

    public ProductDetailsPage(WebDriver driver){
       super(driver);
    }

    @FindBy(id = "back-to-products")
    protected WebElement backToProductsLink;

    @FindBy(xpath = "//button[text()='Add to cart']")
    protected WebElement addToCartBtn;

    public void verifyProduct(){
        WebElement productName = driver.findElement(By.xpath("//div[contains(@class,'inventory_details_name')]"));
        Assert.assertTrue(productName.isDisplayed());

        WebElement productDesc = driver.findElement(By.xpath("//div[contains(@class,'inventory_details_desc large')]"));
        Assert.assertTrue(productDesc.isDisplayed());

        WebElement productPrice = driver.findElement(By.xpath("//div[contains(@class,'inventory_details_price')]"));
        Assert.assertTrue(productPrice.isDisplayed());
    }

    public void addProductToCart(){
        Assert.assertTrue(addToCartBtn.isEnabled());
        addToCartBtn.click();
    }

    public void goToCart(){
        Assert.assertTrue(cart.isDisplayed());
        cart.click();
    }
}