package tests;

import common.Constants;
import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BookTicketPage;
import pages.LoginPage;

public class BookTicketTests extends BaseTest {
    BookTicketPage bookTicketPage = new BookTicketPage();
    LoginPage loginPage = new LoginPage();


    private void login_RailWay(){
        loginPage.clickLoginTab();
        loginPage.login(Constants.USERNAME,Constants.PASSWORD);
    }
    @Test (testName = "Verify that user can book ticket from Sài Gòn to Đà Nẵng successfully")
    public void tc001_BookWithValidInformation_SG_DN() {
        LogHelper.info("Login to RailWay");
        login_RailWay();

        LogHelper.info("Click Book Ticket Tab");
        bookTicketPage.clickBookTicketTab();

        LogHelper.info("Click Book Ticket link");
        bookTicketPage.bookTicket(5, "Sài Gòn", "Đà Nẵng", "Soft bed", "2");

        Assert.assertTrue(
                (bookTicketPage.getDepartStation().equals("Sài Gòn")) & (bookTicketPage.getArriveStation().equals("Đà Nẵng")),
                "Ticket books unsuccessfully!");
    }

    @Test (testName = "Verify that user can book ticket from Quảng Ngãi to Nha Trang successfully")
    public void tc002_BookWithValidInformation_QN_NT() {
        LogHelper.info("Login to RailWay");
        login_RailWay();

        LogHelper.info("Click Book Ticket Tab");
        bookTicketPage.clickBookTicketTab();

        LogHelper.info("Click Book Ticket link");
        bookTicketPage.bookTicket(4, "Quảng Ngãi", "Nha Trang", "Soft bed", "1");

        Assert.assertTrue(
                (bookTicketPage.getDepartStation().equals("Quảng Ngãi")) & (bookTicketPage.getArriveStation().equals("Nha Trang")),
                "Ticket books unsuccessfully!");
    }
}
