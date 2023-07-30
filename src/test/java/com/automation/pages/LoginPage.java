package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage{
    @FindBy(css = "input[type=\"email\"]")
    WebElement usernameInput;

    @FindBy(css = "input[type=\"password\"]")
    WebElement passwordInput;

    @FindBy(xpath = "//button[contains(@class, 'btn-primary')]")
    WebElement loginBtn;
    @FindBy(xpath = "//ng-message[@when='apiLoginFailed']")
    WebElement errorMsg;

    @FindBy(xpath = "//ng-message[@translate='login.content.emailInput.errors.required']")
    WebElement loginMsg;
    @FindBy(xpath = "//ng-message[@translate='login.content.passwordInput.errors.required']")
    WebElement passwMsg;

    public void doLogin(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

    public void verifyInvalidLoginErrorIsDisplayed(){
        Assert.assertTrue(errorMsg.isDisplayed());
    }

    public void verifyLoginMsgIsDisplayed() {
        Assert.assertTrue(loginMsg.isDisplayed());
    }

    public void verifyPasswMsgIsDisplayed() {
        Assert.assertTrue(passwMsg.isDisplayed());
    }


    public void verifyLoginPage() {
        Assert.assertTrue(loginBtn.isDisplayed());
    }
}

