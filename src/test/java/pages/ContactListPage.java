package pages;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ContactListPage extends BasePage {
    public static final By BUTTON_NEW = By.cssSelector("[title=New]");
    public static final By BUTTON_IMPORT = By.cssSelector("[title=Import]");
    String endpoint = "lightning/o/Contact/list?filterName=Recent";
    public static final String CONTACT_LOCATOR = "//*[contains(text(),'%s')]/ancestor::*[@class='slds-cell-edit lockTrigger cellContainer']";

    public ContactListPage(WebDriver driver) {
        super(driver);
    }

    public ContactListPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_IMPORT));
        } catch (TimeoutException ex) {
            Assert.fail("Страница не загрузилась. Не найдена кнопка по локатору " + BUTTON_IMPORT);
        }
        return this;
    }

    public ContactListPage openPage() {
        driver.get(URL+endpoint);
        isPageOpened();
        return this;
    }

    @Step("Create new Contact")
    @Description("Click on New Contact Button")
    public NewContactModal clickOnNewContact() {
        driver.findElement(BUTTON_NEW).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='New Contact']")));
        return new NewContactModal(driver);
    }

    @Step("Validation of creating contact")
    public ContactListPage isContactCreated(String contactName) {
        openPage();
        Assert.assertTrue(driver.findElement(By.xpath(String.format(CONTACT_LOCATOR, contactName))).isDisplayed());
        return new ContactListPage(driver);
    }
}
