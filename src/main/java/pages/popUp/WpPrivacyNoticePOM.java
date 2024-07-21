package pages.popUp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.Base;

public class WpPrivacyNoticePOM {

    public WpPrivacyNoticePOM(Base base) {
        base.wait.urlContains("wp.pl");
        PageFactory.initElements(base.driver, this);
    }

    @FindBy(xpath = "//h3[text()='Cenimy Twoją prywatność']//parent::div")
    public WebElement privacyNoticeDiv;

    @FindBy(xpath = "//button[text()='AKCEPTUJĘ I PRZECHODZĘ DO SERWISU']")
    public WebElement acceptButton;
}