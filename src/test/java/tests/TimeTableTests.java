package tests;

import common.Constants;
import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BookTicketPage;
import pages.LoginPage;
import pages.TicketPricePage;
import pages.TimeTablePage;

public class TimeTableTests extends BaseTest {
    TimeTablePage timeTablePage = new TimeTablePage();
    LoginPage loginPage = new LoginPage();
    TicketPricePage ticketPricePage = new TicketPricePage();
    BookTicketPage bookTicketPage = new BookTicketPage();

    private void login_RailWay(){
        loginPage.clickLoginTab();
        loginPage.login(Constants.USERNAME,Constants.PASSWORD);
    }
    //Verify Check Price link
    @Test(testName = "Verify check price link when clicking")
    public void tc001_CheckLinkCheckPrice_QN_NT() {
        LogHelper.info("Click on TimeTable Tab");
        timeTablePage.clickTimeTableTab();

        LogHelper.info("Click on Check Price Link");
        timeTablePage.clickCheckPrice("Quảng Ngãi", "Nha Trang");

        Assert.assertEquals(
                ticketPricePage.messageDisplay(),
                String.format("Ticket price from %s to %s", "Quảng Ngãi", "Nha Trang"),
                "Data transfers incorrectly");
    }

    @Test
    public void tc002_CheckLinkCheckPrice_DN_SG() {
        LogHelper.info("Click on TimeTable Tab");
        timeTablePage.clickTimeTableTab();

        LogHelper.info("Click on Check Price Link");
        timeTablePage.clickCheckPrice("Đà Nẵng", "Sài Gòn");

        Assert.assertEquals(
                ticketPricePage.messageDisplay(),
                String.format("Ticket price from %s to %s", "Đà Nẵng", "Sài Gòn"),
                "Data transfers incorrectly");
    }

    @Test
    public void tc003_CheckLinkCheckPrice_SG_QN() {
        LogHelper.info("Click on TimeTable Tab");
        timeTablePage.clickTimeTableTab();

        LogHelper.info("Click on Check Price Link");
        timeTablePage.clickCheckPrice("Sài Gòn", "Quảng Ngãi");

        Assert.assertEquals(
                ticketPricePage.messageDisplay(),
                String.format("Ticket price from %s to %s", "Sài Gòn", "Quảng Ngãi"),
                "Data transfers incorrectly");
    }

    @Test
    public void tc004_CheckLinkCheckPrice_NT_H() {
        LogHelper.info("Click on TimeTable Tab");
        timeTablePage.clickTimeTableTab();

        LogHelper.info("Click on Check Price Link");
        timeTablePage.clickCheckPrice("Nha Trang", "Huế");

        Assert.assertEquals(
                ticketPricePage.messageDisplay(),
                String.format("Ticket price from %s to %s", "Nha Trang", "Huế"),
                "Data transfers incorrectly");
    }

    @Test
    public void tc005_CheckLinkCheckPrice_SG_H() {
        LogHelper.info("Click on TimeTable Tab");
        timeTablePage.clickTimeTableTab();

        LogHelper.info("Click on Check Price Link");
        timeTablePage.clickCheckPrice("Sài Gòn", "Huế");

        Assert.assertEquals(
                ticketPricePage.messageDisplay(),
                String.format("Ticket price from %s to %s", "Sài Gòn", "Huế"),
                "Data transfers incorrectly");
    }

    @Test
    public void tc006_CheckLinkCheckPrice_H_NT() {
        LogHelper.info("Click on TimeTable Tab");
        timeTablePage.clickTimeTableTab();

        LogHelper.info("Click on Check Price Link");
        timeTablePage.clickCheckPrice("Huế", "Nha Trang");

        Assert.assertEquals(
                ticketPricePage.messageDisplay(),
                String.format("Ticket price from %s to %s", "Huế", "Nha Trang"),
                "Data transfers incorrectly");
    }

    @Test
    public void tc007_CheckLinkCheckPrice_SG_PT() {
        LogHelper.info("Click on TimeTable Tab");
        timeTablePage.clickTimeTableTab();

        LogHelper.info("Click on Check Price Link");
        timeTablePage.clickCheckPrice("Sài Gòn", "Phan Thiết");

        Assert.assertEquals(
                ticketPricePage.messageDisplay(),
                String.format("Ticket price from %s to %s", "Sài Gòn", "Phan Thiết"),
                "Data transfers incorrectly");
    }

    //Verify Book Ticket link
    @Test(testName = "Verify book ticket link when clicking")
    public void tc008_CheckLinkBookTicket_SG_PT() {
        LogHelper.info("Login to RailWay");
        login_RailWay();

        LogHelper.info("Click on TimeTable Tab");
        timeTablePage.clickTimeTableTab();

        LogHelper.info("Click on Check Price Link");
        timeTablePage.clickBookTicket("Quảng Ngãi", "Nha Trang");

        Assert.assertTrue(
                (bookTicketPage.getSelectedDepartFrom().equals("Quảng Ngãi")) && (bookTicketPage.getSelectedArriveAt().equals("Nha Trang")),
                "Data transfers incorrectly");
    }

    @Test
    public void tc009_CheckLinkBookTicket_SG_H() {
        LogHelper.info("Login to RailWay");
        login_RailWay();

        LogHelper.info("Click on TimeTable Tab");
        timeTablePage.clickTimeTableTab();

        LogHelper.info("Click on Check Price Link");
        timeTablePage.clickBookTicket("Sài Gòn", "Huế");

        Assert.assertTrue(
                (bookTicketPage.getSelectedDepartFrom().equals("Sài Gòn")) && (bookTicketPage.getSelectedArriveAt().equals("Huế")),
                "Data transfers incorrectly");
    }

    @Test
    public void tc010_CheckLinkBookTicket_DN_NT() {
        LogHelper.info("Login to RailWay");
        login_RailWay();

        LogHelper.info("Click on TimeTable Tab");
        timeTablePage.clickTimeTableTab();

        LogHelper.info("Click on Check Price Link");
        timeTablePage.clickBookTicket("Đà Nẵng", "Nha Trang");

        Assert.assertTrue(
                (bookTicketPage.getSelectedDepartFrom().equals("Đà Nẵng")) && (bookTicketPage.getSelectedArriveAt().equals("Nha Trang")),
                "Data transfers incorrectly");

    }


}
