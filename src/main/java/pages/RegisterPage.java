package pages;

import helpers.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage {

    //locators
    private final By txtEmail = By.id("email");
    private final By txtPassword = By.id("password");
    private final By txtConfirmPassword = By.id("confirmPassword");
    private final By txtPid = By.id("pid");
    private final By btnRegister = By.xpath("//input[@value='Register']");
    private final By lblLoginMessage = By.cssSelector("#content>p");
    private final By lblErrorMessage = By.cssSelector(".error");


    //WebElements
    private WebElement getTxtEmail() {
        return DriverHelper.getDriver().findElement(txtEmail);
    }
    private WebElement getTxtPassword() {
        return DriverHelper.getDriver().findElement(txtPassword);
    }
    private WebElement getTxtConfirmPassword() {
        return DriverHelper.getDriver().findElement(txtConfirmPassword);
    }
    private WebElement getTxtPid() {
        return DriverHelper.getDriver().findElement(txtPid);
    }
    private WebElement getBtnRegister() { return DriverHelper.getDriver().findElement(btnRegister); }
    private WebElement getLblLoginMessage (){
        return DriverHelper.getDriver().findElement(lblLoginMessage);
    }
    private WebElement errorMessage() {
        return DriverHelper.getDriver().findElement(lblErrorMessage);
    }

    //Methods
    public String getLoginMessage() {
        return getLblLoginMessage().getText();
    }
    public String getErrorMessage() {
        return errorMessage().getText();
    }

    public void register(String email, String pass, String confirmPass, String pid) {
        getTxtEmail().sendKeys(email);
        getTxtPassword().sendKeys(pass);
        getTxtConfirmPassword().sendKeys(confirmPass);
        getTxtPid().sendKeys(pid);
        getBtnRegister().click();
    }

}
