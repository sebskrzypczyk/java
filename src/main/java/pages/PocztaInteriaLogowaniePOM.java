package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.Base;

public class PocztaInteriaLogowaniePOM {

    private Base base;

    public PocztaInteriaLogowaniePOM(Base base) {
        this.base = base;
        base.wait.urlContains("poczta.interia.pl/logowanie/");
        PageFactory.initElements(base.driver, this);
    }

    @FindBy(className = "rodo-popup")
    public WebElement privacyNoticeDiv;

    @FindBy(className = "rodo-popup-main-agree")
    public WebElement acceptButton;

    @FindBy(xpath = "//span[@class='form__error']")
    public WebElement errorSpan;

    @FindBy(id = "email")
    public WebElement emailInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;
}