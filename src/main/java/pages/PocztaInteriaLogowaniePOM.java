package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.Base;

public class PocztaInteriaLogowaniePOM {

    public PocztaInteriaLogowaniePOM(Base base) {
        base.wait.urlContains("poczta.interia.pl/logowanie/");
        PageFactory.initElements(base.driver, this);
    }

    @FindBy(className = "form__error")
    public WebElement errorSpan;

    @FindBy(id = "email")
    public WebElement emailInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(className = "btn--login")
    public WebElement loginButton;
}