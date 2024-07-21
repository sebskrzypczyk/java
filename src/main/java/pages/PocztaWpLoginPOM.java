package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.Base;

public class PocztaWpLoginPOM {

    public PocztaWpLoginPOM(Base base) {
        base.wait.urlContains("poczta.wp.pl/login/login.html");
        PageFactory.initElements(base.driver, this);
    }

    @FindBy(xpath = "//h3[text()='Cenimy Twoją prywatność']//parent::div")
    public WebElement privacyNoticeDiv;

    @FindBy(xpath = "//button[text()='AKCEPTUJĘ I PRZECHODZĘ DO SERWISU']")
    public WebElement acceptButton;

    @FindBy(id = "login")
    public WebElement loginInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(xpath = "//div[@type='error']")
    public WebElement errorDiv;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;
}