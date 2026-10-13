package com.stark.automation.pages;
import com.stark.automation.utils.Waits; import org.openqa.selenium.By;
public class InventoryPage {
 private final By title = By.cssSelector("[data-test='title']"), backpack = By.id("add-to-cart-sauce-labs-backpack"), cartBadge = By.cssSelector("[data-test='shopping-cart-badge']"), cart = By.cssSelector("[data-test='shopping-cart-link']"), menu = By.id("react-burger-menu-btn"), logout = By.id("logout_sidebar_link");
 public boolean isDisplayed() { return Waits.visible(title).getText().equals("Products"); }
 public InventoryPage addBackpack() { Waits.clickable(backpack); com.stark.automation.core.driver.DriverFactory.getDriver().findElement(backpack).click(); return this; }
 public String cartCount() { return Waits.visible(cartBadge).getText(); }
 public CartPage openCart() { Waits.clickable(cart); com.stark.automation.core.driver.DriverFactory.getDriver().findElement(cart).click(); return new CartPage(); }
 public LoginPage logout() { Waits.clickable(menu); com.stark.automation.core.driver.DriverFactory.getDriver().findElement(menu).click(); Waits.clickable(logout); com.stark.automation.core.driver.DriverFactory.getDriver().findElement(logout).click(); return new LoginPage(); }
}
