package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.PocztaWpLoginPOM;
import pages.popUp.WpPrivacyNoticePOM;

public class FailLoginWpTest extends Base {

    @Test
    @Parameters({"username", "password"})
    public void failLoginWpTest(String username, String password) {
        functions.goToPage("https://poczta.wp.pl/login/login.html");
        WpPrivacyNoticePOM wpPrivacyNoticePOM = new WpPrivacyNoticePOM(this);
        wait.visibilityOf(wpPrivacyNoticePOM.privacyNoticeDiv);
        functions.click(wpPrivacyNoticePOM.acceptButton);
        PocztaWpLoginPOM pocztaWpLoginPOM = new PocztaWpLoginPOM(this);
        functions.sendKeys(pocztaWpLoginPOM.loginInput, username);
        functions.sendKeys(pocztaWpLoginPOM.passwordInput, password);
        functions.click(pocztaWpLoginPOM.submitButton);
        wait.visibilityOf(pocztaWpLoginPOM.errorDiv);
        Assert.assertEquals(pocztaWpLoginPOM.errorDiv.getText(), "Nieprawidłowy adres e‑mail lub hasło", "Different error message!");
    }
}