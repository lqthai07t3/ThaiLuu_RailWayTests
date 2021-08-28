package pages;

import helpers.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    //Locators
    private final By txtEmail = By.id("username");
    private final By txtPassword = By.id("password");
    private final By btnLogin = By.xpath("//input[@value='Login']");
    private final By lblErrorMessage = By.className("error");

    //WebElements
    private WebElement getTxtEmail() {
        return DriverHelper.getDriver().findElement(txtEmail);
    }
    private WebElement getTxtPassword() {
        return DriverHelper.getDriver().findElement(txtPassword);
    }
    private WebElement getBtnLogin() {
        return DriverHelper.getDriver().findElement(btnLogin);
    }


    //Methods
    public String getErrorMessage() {
        return DriverHelper.getDriver().findElement(lblErrorMessage).getText();
    }
    public void login(String email, String pass) {
        getTxtEmail().sendKeys(email);
        getTxtPassword().sendKeys(pass);
        getBtnLogin().click();
    }


}
