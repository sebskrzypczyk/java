package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.Base;

public class PocztaInteriaNextPOM {

    public PocztaInteriaNextPOM(Base base) {
        base.wait.urlContains("poczta.interia.pl/next/");
        PageFactory.initElements(base.driver, this);
    }

    @FindBy(className = "navigation__new__text")
    public WebElement newTextSpan;

    @FindBy(className = "section--message-list")
    public WebElement messageaListSection;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement alertDiv;
}