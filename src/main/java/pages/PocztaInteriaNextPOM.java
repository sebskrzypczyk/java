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

    public static String messageSubjectXpath = "//span[@class='msglist-item__message__subject-text' and text()='%s']//ancestor::div[@role='button']";

    @FindBy(className = "section--message")
    public WebElement messageaSection;

    @FindBy(xpath = "//h1[@class='message-header__subject']/span")
    public WebElement subjectH1;

    @FindBy(className = "icon-trash")
    public WebElement trashIcon;

    @FindBy(className = "message-iframe")
    public WebElement messageIframe;

    @FindBy(xpath = "//p")
    public WebElement messageBody;

    @FindBy(className = "avatar--large")
    public WebElement avatarContentDiv;
}