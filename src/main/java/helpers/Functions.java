package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import tests.Base;

public class Functions {

    private Base base;

    public Functions(Base base) {
        this.base = base;
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
        webElement.click();
        System.out.println("Element clicked: " + webElement.getText());
    }

    public void sendKeys(WebElement webElement, String string) {
        base.wait.visibilityOf(webElement);
        base.wait.elementToBeClickable(webElement);
        webElement.clear();
        webElement.sendKeys(string);
        Assert.assertEquals(webElement.getAttribute("value"), string, "The send value is different!");
        System.out.println("To the Element: " + webElement.getText() + "\nhas been sent: " + string);
    }
}
