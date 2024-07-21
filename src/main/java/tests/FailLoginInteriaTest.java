package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.PocztaInteriaLogowaniePOM;
import pages.popUp.InteriaPrivacyNoticePOM;

public class FailLoginInteriaTest extends Base {

    @Test
    @Parameters({"email", "password"})
    public void failLoginInteriaTest(String email, String password) {
        functions.goToPage("https://poczta.interia.pl/logowanie/");
        InteriaPrivacyNoticePOM interiaPrivacyNoticePOM = new InteriaPrivacyNoticePOM(this);
        wait.visibilityOf(interiaPrivacyNoticePOM.privacyNoticeDiv);
        functions.click(interiaPrivacyNoticePOM.acceptButton);
        PocztaInteriaLogowaniePOM pocztaInteriaLogowaniePOM = new PocztaInteriaLogowaniePOM(this);
        functions.sendKeys(pocztaInteriaLogowaniePOM.emailInput, email);
        functions.sendKeys(pocztaInteriaLogowaniePOM.passwordInput, password);
        functions.click(pocztaInteriaLogowaniePOM.loginButton);
        wait.visibilityOf(pocztaInteriaLogowaniePOM.errorSpan);
        Assert.assertEquals(pocztaInteriaLogowaniePOM.errorSpan.getText(), "Błędny e-mail lub hasło", "Different error message!");
    }
}