package com.automation.tests;

import com.automation.utils.ConfigReader;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void verifyUserCanLogin() {
        loginPage.doLogin(ConfigReader.getProperty("login.username"), ConfigReader.getProperty("login.password"));
        homePage.verifyHomePage();
    }
    @Test
    public void verifyUserCannotLoginWithInvalidCred() {
        loginPage.doLogin("37990@zbock.com", "37990@zbock.com");
        loginPage.verifyInvalidLoginErrorIsDisplayed();
    }
    @Test
    public void verifyUserCannotLoginWithValidLoginAndInvalidPassw() {
        loginPage.doLogin("qgr37990@zbock.com", "qg37990@zbock.com");
        loginPage.verifyInvalidLoginErrorIsDisplayed();
    }
    @Test
    public void verifyUserCannotLoginWithInvalidLoginAndValidPassw() {
        loginPage.doLogin("37990@zbock.com", "qgr37990@zbock.com");
        loginPage.verifyInvalidLoginErrorIsDisplayed();
    }
    @Test
    public void verifyUserCannotLoginWithEmptyCred() {
        loginPage.doLogin("", "");
        loginPage.verifyLoginMsgIsDisplayed();
        loginPage.verifyPasswMsgIsDisplayed();
    }
    @Test
    public void verifyUserCanLogout(){
        loginPage.doLogin(ConfigReader.getProperty("login.username"), ConfigReader.getProperty("login.password"));
        homePage.verifyHomePage();
        homePage.clickOnUserAvatar();
        homePage.clickOnLogoutLink();
        loginPage.verifyLoginPage();
    }


}
