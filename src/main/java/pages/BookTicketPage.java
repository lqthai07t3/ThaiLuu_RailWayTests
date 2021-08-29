package pages;

import helpers.DriverHelper;
import helpers.ElementHelper;
import helpers.TicketHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class BookTicketPage extends BasePage {

    //locators
    private final By cboDate = By.name("Date");
    private final By cboDepartFrom = By.name("DepartStation");
    private final By cboArriveAt = By.name("ArriveStation");
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
    public void selectDepartDate(String date) { getDrpDepartDate().selectByVisibleText(date); }
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
        this.selectDepartDate(ticket.getDepartDate());
        this.selectDepartStation(ticket.getDepartStation());
        this.selectArriveStation(ticket.getArriveStation());
        this.selectSeatType(ticket.getSeatType());
        this.selectTicketAmount(ticket.getTicketAmount());
        ElementHelper.scrollToElement(getBtnBookTicket());
        this.getBtnBookTicket().click();
    }


}
