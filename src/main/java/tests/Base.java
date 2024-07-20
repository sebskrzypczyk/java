package tests;

import helpers.Functions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class Base {

    public WebDriver driver;
    public Functions functions;

    @BeforeTest
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        functions = new Functions(this);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
