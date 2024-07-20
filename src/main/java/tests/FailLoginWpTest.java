package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.PocztaWpLoginPOM;

public class FailLoginWpTest extends Base {

    @Test
    @Parameters({"username", "password"})
    public void failLoginWpTest(String username, String password) {
        functions.goToPage("https://poczta.wp.pl/login/login.html");
        PocztaWpLoginPOM pocztaWpLoginPOM = new PocztaWpLoginPOM(this);
        wait.visibilityOf(pocztaWpLoginPOM.privacyNoticeDiv);
        functions.click(pocztaWpLoginPOM.acceptButton);
        functions.sendKeys(pocztaWpLoginPOM.loginInput, username);
        functions.sendKeys(pocztaWpLoginPOM.passwordInput, password);
        functions.click(pocztaWpLoginPOM.submitButton);
        wait.visibilityOf(pocztaWpLoginPOM.errorDiv);
        Assert.assertEquals(pocztaWpLoginPOM.errorDiv.getText(), "Nieprawidłowy adres e‑mail lub hasło", "Different error message!");
    }
}