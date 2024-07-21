package tests;

import model.Mail;
import model.enums.NotificationMessage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.PocztaInteriaLogowaniePOM;
import pages.PocztaInteriaNextPOM;
import pages.popUp.*;

import org.openqa.selenium.NoSuchElementException;

public class LoginInteriaTest extends Base {
    Mail mail;

    @Test
    @Parameters({"email", "password"})
    public void test01_loginInteriaTest(String email, String password) {
        functions.goToPage("https://poczta.interia.pl/logowanie/");
        try {
            InteriaPrivacyNoticePOM interiaPrivacyNoticePOM = new InteriaPrivacyNoticePOM(this);
            wait.visibilityOf(interiaPrivacyNoticePOM.privacyNoticeDiv);
            functions.click(interiaPrivacyNoticePOM.acceptButton);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        PocztaInteriaLogowaniePOM pocztaInteriaLogowaniePOM = new PocztaInteriaLogowaniePOM(this);
        functions.sendKeys(pocztaInteriaLogowaniePOM.emailInput, email);
        functions.sendKeys(pocztaInteriaLogowaniePOM.passwordInput, password);
        functions.click(pocztaInteriaLogowaniePOM.loginButton);
        PocztaInteriaNextPOM pocztaInteriaNextPOM = new PocztaInteriaNextPOM(this);
        functions.isDisplayed(pocztaInteriaNextPOM.newTextSpan);
        functions.isDisplayed(pocztaInteriaNextPOM.messageaListSection);
    }

    @Test
    @Parameters({"email"})
    public void test02_sendNewMailTest(String email) {
        try {
            functions.click(new DialogContainerPOM(this).dialogCloseIcon);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        PocztaInteriaNextPOM pocztaInteriaNextPOM = new PocztaInteriaNextPOM(this);
        functions.click(pocztaInteriaNextPOM.newTextSpan);
        TemplatePOM templatePOM = new TemplatePOM(this);
        wait.visibilityOf(templatePOM.templateDiv);
        mail = new Mail(email);
        functions.sendKeys(templatePOM.emailImput, mail.getTo());
        functions.sendKeys(templatePOM.subjectImput, mail.getSubject());
        functions.sendKeys(templatePOM.iframe, templatePOM.messageBody, mail.getMessage());
        functions.click(templatePOM.sendButton);
        functions.checkNotificationMessage(new NotificationPOM(this).notificationMessageDiv, NotificationMessage.MESSAGE_SENT);
    }

    @Test
    public void test03_readMailTest() {
        if (mail == null) {
            throw new RuntimeException("No Mail model found!");
        } else {
            PocztaInteriaNextPOM pocztaInteriaNextPOM = new PocztaInteriaNextPOM(this);
            functions.click(functions.findElement(String.format(PocztaInteriaNextPOM.messageSubjectXpath, mail.getSubject())));
            wait.visibilityOf(pocztaInteriaNextPOM.messageaSection);
            Assert.assertEquals(pocztaInteriaNextPOM.subjectH1.getText(), mail.getSubject(), "The subject is different!");
            driver.switchTo().frame(pocztaInteriaNextPOM.messageIframe);
            wait.visibilityOf(pocztaInteriaNextPOM.messageBody);
            Assert.assertEquals(pocztaInteriaNextPOM.messageBody.getText(), mail.getMessage(), "The message is different!");
            driver.switchTo().defaultContent();
        }
    }

    @Test
    public void test04_deleteMailTest() {
        if (mail == null) {
            throw new RuntimeException("No Mail model found!");
        } else {
            PocztaInteriaNextPOM pocztaInteriaNextPOM = new PocztaInteriaNextPOM(this);
            functions.click(pocztaInteriaNextPOM.trashIcon);
            functions.checkNotificationMessage(new NotificationPOM(this).notificationMessageDiv, NotificationMessage.MESSAGE_DELETED);
        }
    }

    @Test
    public void test05_logoutTest() {
        PocztaInteriaNextPOM pocztaInteriaNextPOM = new PocztaInteriaNextPOM(this);
        functions.click(pocztaInteriaNextPOM.avatarContentDiv);
        AccountInfoPOM accountInfoPOM = new AccountInfoPOM(this);
        wait.visibilityOf(accountInfoPOM.accountInfoDiv);
        functions.click(accountInfoPOM.logoutButton);
        Assert.assertTrue(wait.urlContains("interia.pl/wyloguj"), "Wrong URL after logout!");
    }
}