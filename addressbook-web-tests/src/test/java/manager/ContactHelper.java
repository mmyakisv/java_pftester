package manager;

import model.ContactData;
import model.GroupData;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {
    public ContactHelper(ApplicationManager manager) {

        super(manager);
    }

    public boolean isContactPresent() {
        return manager.isElementPresent(By.name("selected[]"));
    }

    public void createContact(ContactData contact) {
        initContactCreation();
        fillContactForm(contact);
        submitContactCreation();
        returnToHomePage();
    }

    private void initContactCreation() {
        click(By.linkText("add new"));

    }

    private void fillContactForm(ContactData contact) {
        type(By.name("firstname"), contact.firstname());
        type(By.name("lastname"), contact.lastname());
        type(By.name("mobile"), contact.mobile());
        type(By.name("email"), contact.email());

    }

    private void submitContactCreation() {
        click(By.name("submit"));
    }

    private void returnToHomePage() {
        click(By.linkText("home page"));
    }


    public void removeContact(ContactData contact) {
        selectContact(contact);
        removeSelectedContact();
    }

    private void removeSelectedContact() {
        click(By.xpath("//input[@value=\'Delete\']"));
        manager.driver.switchTo().alert().accept();
    }

    private void selectContact(ContactData contact) {
        click(By.cssSelector(String.format("input[value='%s']", contact.id())));

    }

    public void modifyContact(ContactData contact, ContactData modifiedContact) {
        selectContact(contact);
        initContactModification();
        fillContactForm(modifiedContact);
        submitContactModification();
        returnToHomePage();

    }

    private void submitContactModification() {
        click(By.name("update"));
    }

    private void initContactModification() {
        click(By.xpath("//img[@alt='Edit']"));
    }


    public List<ContactData> getList() {
        var contacts = new ArrayList<ContactData>();
        var rows = manager.driver.findElements(By.cssSelector("[name=entry]"));
        for (var row : rows) {
            var id = row.findElement(By.name("selected[]")).getAttribute("value");
            var lastname = row.findElement(By.xpath("td[2]")).getText();
            var firstname = row.findElement(By.xpath("td[3]")).getText();
            contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname));

        }
            return contacts;
        }
    public int getCount() {

        return manager.driver.findElements(By.name("selected[]")).size();
    }
}





