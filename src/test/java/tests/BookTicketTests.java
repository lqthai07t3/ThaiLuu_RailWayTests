package tests;

import common.Constants;
import helpers.DateHelper;
import helpers.LogHelper;
import helpers.TicketHelper;
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

        LogHelper.info("Set Ticket Information");
        TicketHelper ticket = new TicketHelper();
        String stringDate = DateHelper.getDateFromToday(15);

        ticket.setDepartDate(stringDate);
        ticket.setDepartStation("Sài Gòn");
        ticket.setArriveStation("Đà Nẵng");
        ticket.setSeatType("Soft bed");
        ticket.setTicketAmount("1");




        LogHelper.info("Click Book Ticket Button");
        bookTicketPage.bookTicket(ticket);

        Assert.assertTrue(
                (bookTicketPage.getDepartStation().equals("Sài Gòn")) && (bookTicketPage.getArriveStation().equals("Đà Nẵng")),
                "Ticket books unsuccessfully!");
    }

    @Test (testName = "Verify that user can book ticket from Quảng Ngãi to Nha Trang successfully")
    public void tc002_BookWithValidInformation_QN_NT() {
        LogHelper.info("Login to RailWay");
        login_RailWay();

        LogHelper.info("Click Book Ticket Tab");
        bookTicketPage.clickBookTicketTab();

        LogHelper.info("Set Ticket Information");
        TicketHelper ticket = new TicketHelper();
        String date = DateHelper.getDateFromToday(5);

        ticket.setDepartDate(date);
        ticket.setDepartStation("Quảng Ngãi");
        ticket.setArriveStation("Nha Trang");
        ticket.setSeatType("Hard bed");
        ticket.setTicketAmount("1");

        LogHelper.info("Click Book Ticket link");
        bookTicketPage.bookTicket(ticket);

        Assert.assertTrue(
                (bookTicketPage.getDepartStation().equals("Quảng Ngãi")) && (bookTicketPage.getArriveStation().equals("Nha Trang")),
                "Ticket books unsuccessfully!");
    }

    @Test (testName = "Verify that user can book ticket from Huế to Phan Thiết successfully")
    public void tc003_BookWithValidInformation_H_PT() {
        LogHelper.info("Login to RailWay");
        login_RailWay();

        LogHelper.info("Click Book Ticket Tab");
        bookTicketPage.clickBookTicketTab();

        LogHelper.info("Set Ticket Information");
        TicketHelper ticket = new TicketHelper();
        String date = DateHelper.getDateFromToday(2);

        ticket.setDepartDate(date);
        ticket.setDepartStation("Huế");
        ticket.setArriveStation("Phan Thiết");
        ticket.setSeatType("Soft bed with air conditioner");
        ticket.setTicketAmount("1");

        LogHelper.info("Click Book Ticket link");
        bookTicketPage.bookTicket(ticket);

        Assert.assertTrue(
                (bookTicketPage.getDepartStation().equals("Huế")) && (bookTicketPage.getArriveStation().equals("Phan Thiết")),
                "Ticket books unsuccessfully!");
    }
}
