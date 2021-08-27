package helpers;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ElementHelper {

    public static void scrollToElement(WebElement element) {
        Actions action = new Actions(DriverHelper.getDriver());
        action.moveToElement(element).perform();
    }



}
