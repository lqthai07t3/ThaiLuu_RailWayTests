package tests;

import common.Constants;
import helpers.DataHelper;
import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegisterPage;

public class RegisterTests extends BaseTest {
    RegisterPage registerPage = new RegisterPage();


    @Test(testName = "Register with valid information")
    public void tc001_RegisterSuccessfully() {
        LogHelper.info("Click on Register Tab");
        registerPage.clickRegisterTab();

        String email = DataHelper.getRandomEmail();
        String pass = DataHelper.getRandomPassword(25);
        String pid = DataHelper.getRandomNumber(12);

        LogHelper.info("Enter Register information");
        registerPage.register(email, pass, pass, pid);

        Assert.assertEquals(
                registerPage.getLoginMessage(),
                "You're here",
                "User can not register successfully with valid information");
    }

    @Test(testName = "Register with blank all fields")
    public void tc002_BlankAllFields() {
        LogHelper.info("Click on Register Tab");
        registerPage.clickRegisterTab();

        LogHelper.info("Enter Register information");
        registerPage.register("", "", "", "");

        Assert.assertEquals(
                registerPage.getErrorMessage(),
                "There're errors in the form. Please correct the errors and try again.",
                "User can register successfully with blank all fields");
    }

    @Test(testName = "Register with Email less than 6 character")
    public void tc003_EmailLessThan6Character() {
        LogHelper.info("Click on Register Tab");
        registerPage.clickRegisterTab();

        String pass = DataHelper.getRandomPassword(11);
        String pid = DataHelper.getRandomNumber(15);

        LogHelper.info("Enter Register information");
        registerPage.register("a@g.k", pass, pass, pid);

        Assert.assertEquals(
                registerPage.getErrorMessage(),
                "There're errors in the form. Please correct the errors and try again.",
                "User can register successfully with less than 6 character Email");
    }

    @Test(testName = "Register with Email more than 32 character")
    public void tc004_EmailMoreThan32Character() {
        LogHelper.info("Click on Register Tab");
        registerPage.clickRegisterTab();

        String pass = DataHelper.getRandomPassword(8);
        String pid = DataHelper.getRandomNumber(8);

        LogHelper.info("Enter Register information");
        registerPage.register("giacmotruachuamotlannholai@it.com", pass, pass, pid);

        Assert.assertEquals(
                registerPage.getErrorMessage(),
                "There're errors in the form. Please correct the errors and try again.",
                "User can register successfully with more than 32 character Email");
    }

    @Test(testName = "Register with invalid Email")
    public void tc005_InvalidFormatEmail() {
        LogHelper.info("Click on Register Tab");
        registerPage.clickRegisterTab();

        String pass = DataHelper.getRandomPassword(17);
        String pid = DataHelper.getRandomNumber(16);

        LogHelper.info("Enter Register information");
        registerPage.register("@gmail.com.vn", pass, pass, pid);

        Assert.assertEquals(
                registerPage.getErrorMessage(),
                "There're errors in the form. Please correct the errors and try again.",
                "User can register successfully with invalid Email");
    }

    @Test(testName = "Register with spcae/special character Email")
    public void tc006_EmailWithSpaceOrSpecialCharacter() {
        LogHelper.info("Click on Register Tab");
        registerPage.clickRegisterTab();

        String pass = DataHelper.getRandomPassword(10);
        String pid = DataHelper.getRandomNumber(9);

        LogHelper.info("Enter Register information");
        registerPage.register("giac*&^%($mo    trua@gma^$#il.com", pass, pass, pid);

        Assert.assertEquals(
                registerPage.getErrorMessage(),
                "There're errors in the form. Please correct the errors and try again.",
                "User can register successfully with space or special character Email");
    }

    @Test(testName = "Register with exist Email")
    public void tc007_RegisterWithExistEmail() {
        LogHelper.info("Click on Register Tab");
        registerPage.clickRegisterTab();

        String pass = DataHelper.getRandomPassword(10);
        String pid = DataHelper.getRandomNumber(20);

        LogHelper.info("Enter Register information");
        registerPage.register(Constants.USERNAME, pass, pass, pid);

        Assert.assertEquals(
                registerPage.getErrorMessage(),
                "There're errors in the form. Please correct the errors and try again.",
                "User can register with exist Email in system");
    }

    @Test(testName = "Register with Password less than 8 character")
    public void tc008_PasswordLessThan8Character() {
        LogHelper.info("Click on Register Tab");
        registerPage.clickRegisterTab();

        String email = DataHelper.getRandomEmail();
        String pass = DataHelper.getRandomPassword(7);
        String pid = DataHelper.getRandomNumber(15);

        LogHelper.info("Enter Register information");
        registerPage.register(email, pass, pass, pid);

        Assert.assertEquals(
                registerPage.getErrorMessage(),
                "There're errors in the form. Please correct the errors and try again.",
                "User can register successfully with 7 character Password");
    }

    @Test(testName = "Register with Password more than 64 character")
    public void tc009_PasswordMoreThan64Character() {
        LogHelper.info("Click on Register Tab");
        registerPage.clickRegisterTab();

        String email = DataHelper.getRandomEmail();
        String pass = DataHelper.getRandomPassword(65);
        String pid = DataHelper.getRandomNumber(17);

        LogHelper.info("Enter Register information");
        registerPage.register(email, pass, pass, pid);

        Assert.assertEquals(
                registerPage.getErrorMessage(),
                "There're errors in the form. Please correct the errors and try again.",
                "User can register successfully with 65 character Password");
    }

    @Test(testName = "Register with confirmPassword not match Password")
    public void tc010_ConfirmPasswordNotMatchPassword() {
        LogHelper.info("Click on Register Tab");
        registerPage.clickRegisterTab();

        LogHelper.info("Enter Register information");
        registerPage.register(
                DataHelper.getRandomEmail(),
                DataHelper.getRandomPassword(12),
                DataHelper.getRandomPassword(15),
                DataHelper.getRandomNumber(10));

        Assert.assertEquals(
                registerPage.getErrorMessage(),
                "There're errors in the form. Please correct the errors and try again.",
                "User can register successfully with ConfirmPassword not match Password");
    }

    @Test(testName = "Register with PID less than 8 character")
    public void tc011_PIDLessThan8Character() {
        LogHelper.info("Click on Register Tab");
        registerPage.clickRegisterTab();

        String email = DataHelper.getRandomEmail();
        String pass = DataHelper.getRandomPassword(12);
        String pid = DataHelper.getRandomNumber(7);

        LogHelper.info("Enter Register information");
        registerPage.register(email, pass, pass, pid);

        Assert.assertEquals(
                registerPage.getErrorMessage(),
                "There're errors in the form. Please correct the errors and try again.",
                "User can register successfully with 7 character PID");
    }

    @Test(testName = "Register with PID more than 20 character")
    public void tc012_PIDMoreThan20Character() {
        LogHelper.info("Click on Register Tab");
        registerPage.clickRegisterTab();

        String email = DataHelper.getRandomEmail();
        String pass = DataHelper.getRandomPassword(16);
        String pid = DataHelper.getRandomNumber(21);

        LogHelper.info("Enter Register information");
        registerPage.register(email, pass, pass, pid);

        Assert.assertEquals(
                registerPage.getErrorMessage(),
                "There're errors in the form. Please correct the errors and try again.",
                "User can register successfully with 21 character PID");
    }

    @Test(testName = "Register with PID more than 20 character")
    public void tc013_NonNumericPID() {
        LogHelper.info("Click on Register Tab");
        registerPage.clickRegisterTab();

        String email = DataHelper.getRandomEmail();
        String pass = DataHelper.getRandomPassword(16);
        String pid = DataHelper.getRandomNumber(21);

        LogHelper.info("Enter Register information");
        registerPage.register(email, pass, pass, pid);

        Assert.assertEquals(
                registerPage.getErrorMessage(),
                "There're errors in the form. Please correct the errors and try again.",
                "User can register successfully with non-numeric character PID");
    }

}
