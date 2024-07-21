package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.PocztaInteriaLogowaniePOM;

public class FailLoginInteriaTest extends Base {

    @Test
    @Parameters({"email", "password"})
    public void failLoginInteriaTest(String email, String password) {
        functions.goToPage("https://poczta.interia.pl/logowanie/");
        PocztaInteriaLogowaniePOM pocztaInteriaLogowaniePOM = new PocztaInteriaLogowaniePOM(this);
        wait.visibilityOf(pocztaInteriaLogowaniePOM.privacyNoticeDiv);
        functions.click(pocztaInteriaLogowaniePOM.acceptButton);
        functions.sendKeys(pocztaInteriaLogowaniePOM.emailInput, email);
        functions.sendKeys(pocztaInteriaLogowaniePOM.passwordInput, password);
        functions.click(pocztaInteriaLogowaniePOM.submitButton);
        wait.visibilityOf(pocztaInteriaLogowaniePOM.errorSpan);
        Assert.assertEquals(pocztaInteriaLogowaniePOM.errorSpan.getText(), "Błędny e-mail lub hasło", "Different error message!");
    }
}