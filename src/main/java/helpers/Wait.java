package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import tests.Base;

import java.time.Duration;
import java.util.List;

public class Wait {

    private Base base;
    private FluentWait<WebDriver> fluentWait;

    public Wait(Base base) {
        this.base = base;
        fluentWait = new FluentWait<>(base.driver)
                .withTimeout(Duration.ofMinutes(2))
                .pollingEvery(Duration.ofMillis(100));
    }

    public static void sleepSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean urlContains(String url) {
        return fluentWait.until(ExpectedConditions.urlContains(url));
    }

    public void visibilityOf(WebElement webElement) {
        fluentWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void visibilityOf(List<WebElement> webElementList) {
        fluentWait.until(ExpectedConditions.visibilityOfAllElements(webElementList));
    }

    public void elementToBeClickable(WebElement webElement) {
        fluentWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
