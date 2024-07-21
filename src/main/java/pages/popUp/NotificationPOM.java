package pages.popUp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.Base;

import java.util.List;

public class NotificationPOM {

    public NotificationPOM(Base base) {
        base.wait.urlContains("poczta.interia.pl/next/");
        PageFactory.initElements(base.driver, this);
    }

    @FindBy(xpath = "//div[@role='alert']")
    public List<WebElement> notificationMessageDiv;
}