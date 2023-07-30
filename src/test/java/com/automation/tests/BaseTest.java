package com.automation.tests;

import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.DriverUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;
public class BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    @BeforeMethod
    public void setUp() {
        // Create the driver
        ConfigReader.initProperties();
        DriverUtils.createDriver();
        initPageObject();
    }

    @AfterMethod
    public void cleanUp() {
        DriverUtils.getDriver().quit();
    }

    public void initPageObject() {
        // Initialize the page object
        loginPage = new LoginPage();
        homePage = new HomePage();
    }
}
