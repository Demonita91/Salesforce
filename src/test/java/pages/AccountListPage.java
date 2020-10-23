package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class AccountListPage extends BasePage {
    String endpoint = "lightning/o/Account/list?filterName=Recent";
    By newButton = By.cssSelector("[title=New]");
    By GetStartedButton = By.cssSelector("//*[contains(text(),'Get Started')]/ancestor::div[contains(@class, 'trial-tours')]//a");

    public AccountListPage(WebDriver driver) {
        super(driver);
    }

    public AccountListPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(GetStartedButton));
        } catch (TimeoutException ex) {
            Assert.fail("Страница не загрузилась. Не найдена кнопка по локатору " + GetStartedButton);
        }
        return this;
    }

    public AccountListPage openPage() {
        driver.get(URL+endpoint);
        isPageOpened();
        return this;
    }

    public NewAccountModal clickNew() {
        driver.findElement(newButton).click();
        return new NewAccountModal(driver);
    }

}
