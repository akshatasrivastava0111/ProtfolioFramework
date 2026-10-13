package com.stark.automation.pages;
import com.stark.automation.utils.Waits; import org.openqa.selenium.By;
public class CartPage { private final By item = By.cssSelector("[data-test='inventory-item-name']"), checkout = By.id("checkout"); public String itemName() { return Waits.visible(item).getText(); } public CheckoutPage checkout() { Waits.clickable(checkout); com.stark.automation.core.driver.DriverFactory.getDriver().findElement(checkout).click(); return new CheckoutPage(); } }
