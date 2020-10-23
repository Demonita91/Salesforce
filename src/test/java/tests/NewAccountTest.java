package tests;

import models.Account;
import org.testng.annotations.Test;

public class NewAccountTest extends BaseTest {


    @Test
    public void createAccount() {
        Account account = new Account("AlexandraTest","tut.by", "Customer",
                "Test","+375292222222","Banking","Test",
                "TestBillingStreet","TestBillingCity","TestBillingState",
                "12547","TestBillingCountry","TestShippingStreet",
                "TestShippingCity","TestShippingState","12566",
                "TestShippingCountry");
        loginPage
                .openPage()
                .login(login, password);
        accountListPage
                .openPage()
                .clickNew()
                .create(account);

    }
}


