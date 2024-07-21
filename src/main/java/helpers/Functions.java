package helpers;

import model.enums.Alert;
import model.enums.DataFormat;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import tests.Base;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Functions {

    private Base base;

    public Functions(Base base) {
        this.base = base;
    }

    public static String getDateNow(DataFormat dataFormat) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(dataFormat.getText()));
    }

    public static String getDateNow() {
        return getDateNow(DataFormat.YEAR_MONTH_DAY_HOUR_MINUTES);
    }

    public void goToPage(String url) {
        base.driver.get(url);
        WebDriverWait wait = new WebDriverWait(base.driver, 60);
        wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
        System.out.println("Page opened: " + url);
    }

    public void click(WebElement webElement) {
        base.wait.visibilityOf(webElement);
        base.wait.elementToBeClickable(webElement);
        System.out.println("Element clicked: " + webElement.getText());
        webElement.click();
    }

    public void sendKeys(WebElement webElement, String string) {
        base.wait.visibilityOf(webElement);
        base.wait.elementToBeClickable(webElement);
        webElement.clear();
        webElement.sendKeys(string);
        Assert.assertEquals(webElement.getAttribute("value"), string, "The send value is different!");
        System.out.println("To the element: " + webElement.getAttribute("name") + "\nhas been sent: " + string);
    }

    public void isDisplayed(WebElement webElement) {
        base.wait.visibilityOf(webElement);
        Assert.assertTrue(webElement.isDisplayed(), "Element is not displayed: " + webElement.getText());
    }

    public void checkAlert(WebElement webElement, Alert alert) {
        base.wait.visibilityOf(webElement);
        Assert.assertEquals(webElement.getText(), alert.getText(), "Alert is different!");
    }
}
