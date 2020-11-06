package tests;

import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest {
    WebDriver driver;
    AccountListPage accountListPage;
    ContactListPage contactListPage;
    LoginPage loginPage;
    HomePage homePage;

    NewAccountModal accountModal;
    NewContactModal contactModal;

    public static final String PASSWORD = "200592zz";
    public static final String LOGIN = "demonita91-bjmx@force.com";

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
        contactListPage = new ContactListPage(driver);
        homePage =new HomePage(driver);


        accountModal = new NewAccountModal(driver);
        contactModal = new NewContactModal(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }
}
