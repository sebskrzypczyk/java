package pages.popUp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.Base;

public class TemplatePOM {

    public TemplatePOM(Base base) {
        base.wait.urlContains("poczta.interia.pl/next/");
        PageFactory.initElements(base.driver, this);
    }

    @FindBy(xpath = "//div[@ng-include='template']")
    public WebElement templateDiv;

    @FindBy(xpath = "//input[@ng-model='inputEmail']")
    public WebElement emailImput;

    @FindBy(id = "subject")
    public WebElement subjectImput;

    @FindBy(xpath = "//iframe[@title='Treść wiadomości']")
    public WebElement iframe;

    @FindBy(id = "tinymce")
    public WebElement messageBody;

    @FindBy(className = "button")
    public WebElement sendButton;
}