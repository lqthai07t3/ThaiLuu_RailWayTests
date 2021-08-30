package pages;

import helpers.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;


public class BookTicketPage extends BasePage {

    //locators
    private final By cboDate = By.name("Date");
    private final By cboDepartFrom = By.name("DepartStation");
    private final By cboArriveAt = By.cssSelector("#ArriveStation>select");
    private final By cboSeatType = By.name("SeatType");
    private final By cboTicketAmount = By.name("TicketAmount");
    private final By btnBookTicket = By.xpath("//input[@value='Book ticket']");
    private final By lblDepartStation = By.xpath("//table[@class='MyTable WideTable']/tbody/tr/td[1]");
    private final By lblArriveStation = By.xpath("//table[@class='MyTable WideTable']/tbody/tr/td[2]");

    //WebElements
    private WebElement getCboDate() { return DriverHelper.getDriver().findElement(cboDate); }
    private WebElement getCboDepartFrom() { return DriverHelper.getDriver().findElement(cboDepartFrom); }
    private WebElement getCboArriveAt() { return DriverHelper.getDriver().findElement(cboArriveAt); }
    private WebElement getCboSeatType() { return DriverHelper.getDriver().findElement(cboSeatType); }
    private WebElement getCboTicketAmount() { return DriverHelper.getDriver().findElement(cboTicketAmount); }
    private WebElement getBtnBookTicket() {
        return DriverHelper.getDriver().findElement(btnBookTicket);
    }
    private WebElement getLbDepartStation() { return DriverHelper.getDriver().findElement(lblDepartStation); }
    private WebElement getLbArriveStation() {
        return DriverHelper.getDriver().findElement(lblArriveStation);
    }

    @org.jetbrains.annotations.NotNull
    private Select getDrpDepartDate() { Select select = new Select(getCboDate()); return select; }
    private Select getDrpDepartFrom() { Select select = new Select(getCboDepartFrom()); return select; }
    private Select getDrpArriveAt() { Select select = new Select(getCboArriveAt()); return select; }
    private Select getDrpSeatType() { Select select = new Select(getCboSeatType()); return select; }
    private Select getDrpTicketAmount() { Select select = new Select(getCboTicketAmount()); return select; }

    // Get value at Combobox
    public String getSelectedDepartDate() {
        return getDrpDepartDate().getFirstSelectedOption().getText();
    }
    public String getSelectedDepartFrom() { return getDrpDepartFrom().getFirstSelectedOption().getText(); }
    public String getSelectedArriveAt() {
        return getDrpArriveAt().getFirstSelectedOption().getText();
    }
    public String getSelectedSeatType() { return getDrpSeatType().getFirstSelectedOption().getText(); }
    public String getSelectedTicketAmount() { return getDrpTicketAmount().getFirstSelectedOption().getText(); }

    //Set value to Combobox
    public void selectDepartDate(String dateString) { getDrpDepartDate().selectByVisibleText(dateString); }
    public void selectDepartStation(String station) {
        getDrpDepartFrom().selectByVisibleText(station);
    }
    public void selectArriveStation(String station) { getDrpArriveAt().selectByVisibleText(station); }
    public void selectSeatType(String seatType) {
        getDrpSeatType().selectByVisibleText(seatType);
    }
    public void selectTicketAmount(String numberOfSeat) {
        getDrpTicketAmount().selectByVisibleText(numberOfSeat);
    }

    //Methods
    public String getDepartStation() { return getLbDepartStation().getText(); }
    public String getArriveStation() {
        return getLbArriveStation().getText();
    }

//    public void bookTicket(int theDayFromNow, String from, String at, String seat, String numberOfTicket) {
//        selectDepartDate(theDayFromNow);
//        selectDepartStation(from);
//        selectArriveStation(at);
//        selectSeatType(seat);
//        selectTicketAmount(numberOfTicket);
//        getBtnBookTicket().click();
//    }

    public void bookTicket(TicketHelper ticket){
        this.getCboDate().click();
        this.selectDepartDate(ticket.getDepartDate());
        this.getCboDepartFrom().click();
        this.selectDepartStation(ticket.getDepartStation());
        DriverHelper.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.getCboArriveAt().click();
        //Wait for Arrive Station loads full
        DriverHelper.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.selectArriveStation(ticket.getArriveStation());
        this.getCboSeatType().click();
        this.selectSeatType(ticket.getSeatType());
        this.getCboTicketAmount().click();
        this.selectTicketAmount(ticket.getTicketAmount());
        ElementHelper.scrollToElement(getBtnBookTicket());
        this.getBtnBookTicket().click();
    }


}
