package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'status bg-danger')]")
    WebElement status;
    @FindBy(xpath = "//span[@translate='dashboard.selectedDashboardButtonGroup.guide' and @class='ng-scope']")
    WebElement serviceGuide;
    @FindBy(xpath = "//span[contains(text(), \"Выйти\")]\n")
    WebElement logoutLink;

    public void verifyHomePage() {
        Assert.assertTrue(serviceGuide.isDisplayed());
    }
    public void clickOnUserAvatar() {
        status.click();
    }
    public void clickOnLogoutLink() {
        logoutLink.click();
    }
}
