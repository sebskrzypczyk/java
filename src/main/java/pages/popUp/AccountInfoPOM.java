package pages.popUp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.Base;

public class AccountInfoPOM {

    public AccountInfoPOM(Base base) {
        base.wait.urlContains("poczta.interia.pl/next/");
        PageFactory.initElements(base.driver, this);
    }

    @FindBy(className = "account-info")
    public WebElement accountInfoDiv;

    @FindBy(className = "account-info__logout")
    public WebElement logoutButton;
}