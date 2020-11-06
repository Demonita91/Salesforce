package tests;

import io.qameta.allure.Description;
import models.Account;
import org.testng.annotations.Test;

public class NewAccountTest extends BaseTest {

    @Test
    @Description("Authorization and creation of a new account")
    public void createAccount() {
        Account account = new Account("AlexandraTest2","tut.by", "Competitor",
                "Test","+375292222222","Banking","Test",
                "TestBillingStreet","TestBillingCity","TestBillingState",
                "12547","TestBillingCountry","TestShippingStreet",
                "TestShippingCity","TestShippingState","12566",
                "TestShippingCountry");
        loginPage
                .openPage()
                .login(BaseTest.LOGIN, BaseTest.PASSWORD);
        accountListPage
                .openPage()
                .clickOnNewAccount()
                .create(account)
                .clickButtonSave()
                .isAccountCreated("AlexandraTest2");

    }

}


