package pages.popUp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.Base;

public class DialogContainerPOM {

    public DialogContainerPOM(Base base) {
        base.wait.urlContains("poczta.interia.pl/next/");
        PageFactory.initElements(base.driver, this);
    }

    @FindBy(className = "dialog__close")
    public WebElement dialogCloseIcon;
}