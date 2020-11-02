package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HomePage extends BasePage {
    public static final String ENDPOINT = "lightning/page/home";
    public static final By TITLE_OF_WIDGET = By.cssSelector("[ title='Today's Events']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage openPage() {
        driver.get(URL + ENDPOINT);
        return this;
    }

    public HomePage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE_OF_WIDGET));
        } catch (TimeoutException ex) {
            Assert.fail("Страница не загрузилась. Не найдена кнопка по локатору " + TITLE_OF_WIDGET);
        }
        return this;
    }

}
