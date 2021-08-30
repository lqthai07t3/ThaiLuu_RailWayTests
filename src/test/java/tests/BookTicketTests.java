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

//    @Test (testName = "Verify that user can book ticket from Sài Gòn to Đà Nẵng successfully")
//    public void tc001_BookWithValidInformation_H_NT() {
//        LogHelper.info("Login to RailWay");
//        login_RailWay();
//
//        LogHelper.info("Click Book Ticket Tab");
//        bookTicketPage.clickBookTicketTab();
//
//        LogHelper.info("Set Ticket Information");
//
//        LogHelper.info("Click Book Ticket Button");
//        bookTicketPage.bookTicket(5,"Huế","Nha Trang","Soft bed","1");
//
//        Assert.assertTrue(
//                (bookTicketPage.getDepartStation().equals("Huế")) && (bookTicketPage.getArriveStation().equals("Nha Trang")),
//                "Ticket books unsuccessfully!");
//    }

    @Test (testName = "Verify that user can book ticket from Sài Gòn to Đà Nẵng successfully")
    public void tc001_BookWithValidInformation_SG_H() {
        LogHelper.info("Login to RailWay");
        login_RailWay();

        LogHelper.info("Click Book Ticket Tab");
        bookTicketPage.clickBookTicketTab();

        LogHelper.info("Set Ticket Information");
        TicketHelper ticket = new TicketHelper();
        String stringDate = DateHelper.getDateFromToday(10);

        ticket.setDepartDate(stringDate);
        ticket.setDepartStation("Sài Gòn");
        ticket.setArriveStation("Huế");
        ticket.setSeatType("Soft bed");
        ticket.setTicketAmount("1");




        LogHelper.info("Click Book Ticket Button");
        bookTicketPage.bookTicket(ticket);

        Assert.assertTrue(
                (bookTicketPage.getDepartStation().equals("Sài Gòn")) && (bookTicketPage.getArriveStation().equals("Huế")),
                "Ticket books unsuccessfully!");
    }

    @Test (testName = "Verify that user can book ticket from Quảng Ngãi to Nha Trang successfully")
    public void tc002_BookWithValidInformation_PT_NT() {
        LogHelper.info("Login to RailWay");
        login_RailWay();

        LogHelper.info("Click Book Ticket Tab");
        bookTicketPage.clickBookTicketTab();

        LogHelper.info("Set Ticket Information");
        TicketHelper ticket = new TicketHelper();
        String date = DateHelper.getDateFromToday(5);

        ticket.setDepartDate(date);
        ticket.setDepartStation("Phan Thiết");
        ticket.setArriveStation("Nha Trang");
        ticket.setSeatType("Hard bed");
        ticket.setTicketAmount("1");

        LogHelper.info("Click Book Ticket link");
        bookTicketPage.bookTicket(ticket);

        Assert.assertTrue(
                (bookTicketPage.getDepartStation().equals("Phan Thiết")) && (bookTicketPage.getArriveStation().equals("Nha Trang")),
                "Ticket books unsuccessfully!");
    }

    @Test (testName = "Verify that user can book ticket from Huế to Phan Thiết successfully")
    public void tc003_BookWithValidInformation_H_DN() {
        LogHelper.info("Login to RailWay");
        login_RailWay();

        LogHelper.info("Click Book Ticket Tab");
        bookTicketPage.clickBookTicketTab();

        LogHelper.info("Set Ticket Information");
        TicketHelper ticket = new TicketHelper();
        String date = DateHelper.getDateFromToday(5);

        ticket.setDepartDate(date);
        ticket.setDepartStation("Huế");
        ticket.setArriveStation("Đà Nẵng");
        ticket.setSeatType("Soft bed with air conditioner");
        ticket.setTicketAmount("1");

        LogHelper.info("Click Book Ticket link");
        bookTicketPage.bookTicket(ticket);

        Assert.assertTrue(
                (bookTicketPage.getDepartStation().equals("Huế")) && (bookTicketPage.getArriveStation().equals("Đà Nẵng")),
                "Ticket books unsuccessfully!");
    }
}
