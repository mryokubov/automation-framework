package com.academy.techcenture.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.List;

public class ProductsPage extends BasePage{

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "product_sort_container")
    protected WebElement filter;

    public void verifyUserIsOnProductsPage(){
        Assert.assertTrue(secondaryHeader.isDisplayed());
    }

    public void filter(String filterMethod){
        Select select = new Select(filter);
        select.selectByValue(filterMethod);
    }

    public void selectFirstItem(){
        WebElement firstItem = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
        firstItem.click();
    }

    public void verifyFilterProducts(String[] filteredItems) {
        List<WebElement> inventoryItemNames = driver.findElements(By.className("inventory_item_name"));
        for (int i = 0; i < inventoryItemNames.size(); i++) {
            String productName = inventoryItemNames.get(i).getText().trim();
            Assert.assertEquals(productName, filteredItems[i]);
        }
    }
}
