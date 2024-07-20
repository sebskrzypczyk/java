package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import tests.Base;

import java.time.Duration;

public class Wait {

    private Base base;
    private FluentWait<WebDriver> fluentWait;

    public Wait(Base base) {
        this.base = base;
        fluentWait = new FluentWait<>(base.driver)
                .withTimeout(Duration.ofMinutes(2))
                .pollingEvery(Duration.ofMillis(100));
    }

    public void urlContains(String url){
        fluentWait.until(ExpectedConditions.urlContains(url));
    }

    public void visibilityOf(WebElement webElement){
        fluentWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void invisibilityOf(WebElement webElement){
        fluentWait.until(ExpectedConditions.invisibilityOf(webElement));
    }

    public void elementToBeClickable(WebElement webElement){
        fluentWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
