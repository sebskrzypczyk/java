package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FailLoginWpTest extends Base {

    @Test
    @Parameters({"username", "password"})
    public void failLoginWpTest(String username, String password) {
        functions.goToPage("https://poczta.wp.pl/login/login.html");
    }
}
