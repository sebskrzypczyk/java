package pages.popUp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.Base;

public class InteriaPrivacyNoticePOM {

    public InteriaPrivacyNoticePOM(Base base) {
        base.wait.urlContains("interia.pl");
        PageFactory.initElements(base.driver, this);
    }

    @FindBy(className = "rodo-popup")
    public WebElement privacyNoticeDiv;

    @FindBy(className = "rodo-popup-main-agree")
    public WebElement acceptButton;
}