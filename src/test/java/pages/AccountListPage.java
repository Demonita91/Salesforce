package pages;

import com.sun.org.glassfish.gmbal.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class AccountListPage extends BasePage {
    String endpoint = "lightning/o/Account/list?filterName=Recent";
    public static final By BUTTON_NEW = By.cssSelector("[title=New]");
    public static final By BUTTON_IMPORT = By.cssSelector("[title=Import]");
    public static final By ACCOUNT_NAME = By.cssSelector("[title=Account Name]");
    public static final String ACCOUNT_LOCATOR = "//*[@class='scroller actionBarPlugin']//tbody//tr//span//a[text()='%s']";


    public AccountListPage(WebDriver driver) {
        super(driver);
    }

    public AccountListPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_IMPORT));
        } catch (TimeoutException ex) {
            Assert.fail("Страница не загрузилась. Не найдена кнопка по локатору " + BUTTON_IMPORT);
        }
        return this;
    }

    public AccountListPage openPage() {
        driver.get(URL + endpoint);
        isPageOpened();
        return this;
    }

    @Step("Create new Account")
    @Description("Click on New Account Button")
    public NewAccountModal clickOnNewAccount() {
        driver.findElement(BUTTON_NEW).click();
        return new NewAccountModal(driver);
    }

    @Step("Validation of creating account")
    public AccountListPage isAccountCreated(String accountName) {
        openPage();
        Assert.assertTrue(driver.findElement(By.xpath(String.format(ACCOUNT_LOCATOR, accountName))).isDisplayed());
        return new AccountListPage(driver);
    }

}
