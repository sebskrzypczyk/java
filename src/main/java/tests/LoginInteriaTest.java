package tests;

import model.Mail;
import model.enums.Alert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.PocztaInteriaLogowaniePOM;
import pages.PocztaInteriaNextPOM;
import pages.popUp.TemplatePOM;

public class LoginInteriaTest extends Base {
    Mail mail;

    @Test
    @Parameters({"email", "password"})
    public void test01_loginInteriaTest(String email, String password) {
        functions.goToPage("https://poczta.interia.pl/logowanie/");
        PocztaInteriaLogowaniePOM pocztaInteriaLogowaniePOM = new PocztaInteriaLogowaniePOM(this);
        wait.visibilityOf(pocztaInteriaLogowaniePOM.privacyNoticeDiv);
        functions.click(pocztaInteriaLogowaniePOM.acceptButton);
        functions.sendKeys(pocztaInteriaLogowaniePOM.emailInput, email);
        functions.sendKeys(pocztaInteriaLogowaniePOM.passwordInput, password);
        functions.click(pocztaInteriaLogowaniePOM.submitButton);
        PocztaInteriaNextPOM pocztaInteriaNextPOM = new PocztaInteriaNextPOM(this);
        functions.isDisplayed(pocztaInteriaNextPOM.newTextSpan);
        functions.isDisplayed(pocztaInteriaNextPOM.messageaListSection);
    }

    @Test
    @Parameters({"email"})
    public void test02_sendNewMailTest(String email) {
        PocztaInteriaNextPOM pocztaInteriaNextPOM = new PocztaInteriaNextPOM(this);
        functions.click(pocztaInteriaNextPOM.newTextSpan);
        TemplatePOM templatePOM = new TemplatePOM(this);
        wait.visibilityOf(templatePOM.templateDiv);
        mail = new Mail(email);
        functions.sendKeys(templatePOM.emailImput, mail.getTo());
        functions.sendKeys(templatePOM.subjectImput, mail.getSubject());
        functions.sendKeys(templatePOM.messageBody, mail.getMessage());
        functions.click(templatePOM.subjectImput);
        functions.checkAlert(pocztaInteriaNextPOM.alertDiv, Alert.MESSAGE_SENT);
    }

    @Test
    public void test03_deleteMailTest() {
        if (mail == null) {
            throw new RuntimeException("No Mail model found!");
        } else {
            PocztaInteriaNextPOM pocztaInteriaNextPOM = new PocztaInteriaNextPOM(this);
            functions.click(pocztaInteriaNextPOM.newTextSpan);
            TemplatePOM templatePOM = new TemplatePOM(this);
            wait.visibilityOf(templatePOM.templateDiv);
            functions.sendKeys(templatePOM.emailImput, mail.getTo());
            functions.sendKeys(templatePOM.subjectImput, mail.getSubject());
            functions.sendKeys(templatePOM.messageBody, mail.getMessage());
            functions.click(templatePOM.subjectImput);
            functions.checkAlert(pocztaInteriaNextPOM.alertDiv, Alert.MESSAGE_SENT);
        }
    }
}