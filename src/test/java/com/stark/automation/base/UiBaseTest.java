package com.stark.automation.base;
import com.stark.automation.core.driver.DriverFactory; import org.testng.annotations.AfterMethod; import org.testng.annotations.BeforeMethod;
public abstract class UiBaseTest { @BeforeMethod(alwaysRun = true) public void startBrowser() { DriverFactory.start(); } @AfterMethod(alwaysRun = true) public void closeBrowser() { DriverFactory.quit(); } }
