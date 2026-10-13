package com.stark.automation.pages;
import com.stark.automation.utils.Waits; import org.openqa.selenium.By;
public class LoginPage {
 private final By username = By.id("user-name"), password = By.id("password"), login = By.id("login-button"), error = By.cssSelector("[data-test='error']");
 public LoginPage open(String url) { com.stark.automation.core.driver.DriverFactory.getDriver().get(url); Waits.visible(login); return this; }
 public InventoryPage loginAs(String user, String pass) { Waits.visible(username).sendKeys(user); Waits.visible(password).sendKeys(pass); Waits.clickable(login); com.stark.automation.core.driver.DriverFactory.getDriver().findElement(login).click(); return new InventoryPage(); }
 public String errorMessage() { return Waits.visible(error).getText(); }
}
