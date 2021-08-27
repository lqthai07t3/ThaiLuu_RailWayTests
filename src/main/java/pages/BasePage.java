package pages;


import helpers.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {

    //locator
    private By loginTab = By.cssSelector("a[href*='Login']");
    private By registerTab = By.cssSelector("a[href*='Register']>span");
    private By bookTicketTab = By.cssSelector("a[href*='BookTicket']");
    private By ticketPriceTab = By.cssSelector("a[href*='TrainPrice']");
    private By timeTableTab = By.cssSelector("a[href*='TrainTimeList']");
    private By contactTab = By.cssSelector("a[href*='Contact']");
    private By faqTab = By.cssSelector("a[href*='FAQ']");
    private By homeTab = By.cssSelector("a[href='../']");
    private By changePasswordTab = By.cssSelector("a[href*='ChangePassword']");
    private By logoutTab = By.cssSelector("a[href*='Logout']");

    //WebElement
    private WebElement getLoginTab() {
        return DriverHelper.getDriver().findElement(loginTab);
    }
    private WebElement getRegisterTab() {
        return DriverHelper.getDriver().findElement(registerTab);
    }
    private WebElement getBookTicketTab() {
        return DriverHelper.getDriver().findElement(bookTicketTab);
    }
    private WebElement getTicketPriceTab() {
        return DriverHelper.getDriver().findElement(ticketPriceTab);
    }
    private WebElement getTimeTableTab() {
        return DriverHelper.getDriver().findElement(timeTableTab);
    }
    private WebElement getContactTab() {
        return DriverHelper.getDriver().findElement(contactTab);
    }
    private WebElement getFaqTab() {
        return DriverHelper.getDriver().findElement(faqTab);
    }
    private WebElement getHomeTab() {
        return DriverHelper.getDriver().findElement(homeTab);
    }
    private WebElement getChangePasswordTab() {
        return DriverHelper.getDriver().findElement(changePasswordTab);
    }
    private WebElement getLogoutTab() {
        return DriverHelper.getDriver().findElement(logoutTab);
    }

    //Methods
    public void clickLoginTab() {
        getLoginTab().click();
    }
    public void clickRegisterTab() {
        getRegisterTab().click();
    }
    public void clickBookTicketTab() {
        getBookTicketTab().click();
    }
    public void clickTicketPriceTab() {
        getTicketPriceTab().click();
    }
    public void clickTimeTableTab() {
        getTimeTableTab().click();
    }
    public void clickContactTab() {
        getContactTab().click();
    }
    public void clickFAQTab() {
        getFaqTab().click();
    }
    public void clickHomeTab() {
        getHomeTab().click();
    }
    public void clickChangePasswordTab() {
        getChangePasswordTab().click();
    }
    public void clickLogoutTab() {
        getLogoutTab().click();
    }

    public String getTitlePage() { return DriverHelper.getDriver().getTitle(); }
    public Boolean isLogoutTabDisplay(){ return getLogoutTab().isDisplayed(); }
}
