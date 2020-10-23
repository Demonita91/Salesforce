package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.AccountListPage;
import pages.LoginPage;
import pages.NewAccountModal;
import pages.NewContactModal;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;
    AccountListPage accountListPage;
    LoginPage loginPage;
    NewAccountModal accountModal;
    NewContactModal contactModal;

    String password = "200592zz";
    String login = "demonita91-bjmx@force.com";

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        accountListPage = new AccountListPage(driver);
        accountModal = new NewAccountModal(driver);
        contactModal = new NewContactModal(driver);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
