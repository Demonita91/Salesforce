package pages;

import elements.DropDown;
import elements.Input;
import elements.TextArea;
import io.qameta.allure.Step;
import models.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewAccountModal {
    WebDriver driver;
    public static By SAVE_BUTTON = By.xpath("//button[@title='Save']");
    public static By SAVE_AND_NEW_BUTTON = By.xpath("//button[@title='Save & New']");
    public static By CANCEL_BUTTON = By.xpath("//button[@title='Cancel']");

    public NewAccountModal(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Create new Account")
    public NewAccountModal create(Account account) {
        new Input(driver, "Account Name").write(account.getAccountName());
        new Input(driver, "Website").write(account.getWebsite());
        new Input(driver, "Phone").write(account.getPhone());
        new Input(driver, "Employees").write(account.getEmployees());

        new Input(driver, "Billing City").write(account.getBillingCity());
        new Input(driver, "Billing State/Province").write(account.getBillingState());
        new Input(driver, "Billing Zip/Postal Code").write(account.getBillingZip());
        new Input(driver, "Billing Country").write(account.getBillingCountry());

        new Input(driver, "Shipping City").write(account.getShippingCity());
        new Input(driver, "Shipping Zip/Postal Code").write(account.getShippingZip());
        new Input(driver, "Shipping State/Province").write(account.getShippingState());
        new Input(driver, "Shipping Country").write(account.getShippingCountry());

        new DropDown(driver, "Type").select(account.getType());
        new DropDown(driver, "Industry").select(account.getIndustry());

        new TextArea(driver, "Description").write(account.getDescription());
        new TextArea(driver, "Billing Street").write(account.getBillingStreet());
        new TextArea(driver, "Shipping Street").write(account.getShippingStreet());
        return this;
    }

    public AccountListPage clickButtonSave() {
        driver.findElement(SAVE_BUTTON).click();
        return new AccountListPage(driver);
    }
}
