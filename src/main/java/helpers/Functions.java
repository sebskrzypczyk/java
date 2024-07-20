package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.Base;

public class Functions {

    private Base base;

    public Functions(Base base) {
        this.base = base;
    }

    public void goToPage(String url) {
        base.driver.get(url);
        WebDriverWait wait = new WebDriverWait(base.driver, 60);
        wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
        System.out.println("Page opened: " + url);
    }
}
