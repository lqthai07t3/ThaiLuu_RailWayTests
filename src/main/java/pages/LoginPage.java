package pages;

import helpers.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    //Locators
    private By txtEmail = By.id("username");
    private By txtPassword = By.id("password");
    private By btnLogin = By.xpath("//input[@value='Login']");
    private By lblErrorMessage = By.className("error");

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
    public String getErrorMessage() {
        return DriverHelper.getDriver().findElement(lblErrorMessage).getText();
    }

    //Methods
    public void login(String email, String pass) {
        getTxtEmail().sendKeys(email);
        getTxtPassword().sendKeys(pass);
        getBtnLogin().click();
    }


}
