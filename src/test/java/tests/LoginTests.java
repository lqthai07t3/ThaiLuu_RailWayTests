package tests;

import common.Constants;
import helpers.DriverHelper;
import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTest {
    LoginPage loginPage = new LoginPage();


    @Test(testName = "Log in with valid account")
    public void tc001_LoginWithValidAccount() {
        LogHelper.info("Click on Login Tab");
        loginPage.clickLoginTab();

        LogHelper.info("Enter Login information");
        loginPage.login(Constants.USERNAME, Constants.PASSWORD);

        Assert.assertTrue(
                (DriverHelper.getTitlePage().equals("Safe Railway - Selenium Automation"))&&(loginPage.isLogoutTabDisplayed()),
                "User logs in unsuccessfully with valid account");
    }

    @Test(testName = "Log in with invalid account")
    public void tc002_LoginWithInvalidAccount() {
        LogHelper.info("Click on Login Tab");
        loginPage.clickLoginTab();

        LogHelper.info("Enter Login information");
        loginPage.login("rtgrge@gmail.com", "36925814");

        Assert.assertEquals(
                loginPage.getErrorMessage(),
                "Invalid username or password. Please try again.",
                "User logs in successfully with invalid account");
    }
}


