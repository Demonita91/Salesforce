package tests;

import io.qameta.allure.Description;
import models.Contact;
import org.testng.annotations.Test;

public class NewContactTest extends BaseTest {
    @Test
    @Description("Authorization and creation of a new contact")
    public void createContact() {
        Contact contact = new Contact("Mrs.","Alex","TestMiddleName",
                "TestLastName","TestSuffix","AlexandraTest2","TestTitle","TestEmail@gmail.com",
                "+5753555","+59855555","TestDepartment","+52555353",
                "Test Mailing City","25255","Test State",
                "TestCountry", "Test Street");
        loginPage
                .openPage()
                .login(BaseTest.LOGIN, BaseTest.PASSWORD);
        contactListPage
                .openPage()
                .clickOnNewContact()
                .create(contact)
                .clickButtonSave()
                .isContactCreated("Alex TestMiddleName TestLastName TestSuffix");
    }

}
