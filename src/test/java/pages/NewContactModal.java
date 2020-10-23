package pages;

import elements.DropDown;
import elements.Input;
import elements.TextArea;
import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewContactModal {
    WebDriver driver;
    public static By SAVE_BUTTON = By.xpath("//button[@title='Save']");
    public static By SAVE_AND_NEW_BUTTON = By.xpath("//button[@title='Save & New']");
    public static By CANCEL_BUTTON = By.xpath("//button[@title='Cancel']");

    public NewContactModal(WebDriver driver) {
        this.driver = driver;
    }

    public void create(Contact contact){
        new Input(driver, "First Name").write(contact.getFirstName());
        new Input(driver, "Middle Name").write(contact.getMiddleName());
        new Input(driver, "Last Name").write(contact.getLastName());
        new Input(driver, "Suffix").write(contact.getSuffix());
        new Input(driver, "Title").write(contact.getTitle());
        new Input(driver, "Email").write(contact.getEmail());
        new Input(driver, "Phone").write(contact.getPhone());
        new Input(driver, "Mobile").write(contact.getMobile());
        new Input(driver, "Department").write(contact.getDepartment());
        new Input(driver, "Fax").write(contact.getFax());
        new Input(driver, "Mailing City").write(contact.getMailingCity());
        new Input(driver, "Mailing Zip/Postal Code").write(contact.getMailingZipCode());
        new Input(driver, "Mailing State/Province").write(contact.getMailingState());
        new Input(driver, "Mailing Country").write(contact.getMailingCountry());

        new DropDown(driver, "Salutation").select(contact.getSalutation());

        new TextArea(driver, "Mailing Street").write(contact.getMailingStreet());

    }
}
