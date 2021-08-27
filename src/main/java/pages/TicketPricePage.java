package pages;

import helpers.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TicketPricePage extends BasePage {

    //locators
    private final By titleOfTableTicket = By.xpath("//th[starts-with(text(),'Ticket price from')]");

    //WebElements
    private WebElement getTitleOfTableTicket() { return DriverHelper.getDriver().findElement(titleOfTableTicket); }

    //Methods
    public String messageDisplay() {
        return getTitleOfTableTicket().getText();
    }
}
