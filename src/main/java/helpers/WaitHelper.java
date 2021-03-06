package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
    public static void untilElementVisible(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(DriverHelper.getDriver(), seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
