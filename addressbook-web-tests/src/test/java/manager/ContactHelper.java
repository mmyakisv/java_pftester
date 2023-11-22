package manager;

import model.ContactData;
import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

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

    public void createContact(ContactData contact, GroupData group) {
        initContactCreation();
        fillContactForm(contact);
        selectGroup(group);
        submitContactCreation();
        returnToHomePage();
    }

    public void addContactToGroup(ContactData contact, GroupData group) {
        initContactCreation();
        fillContactForm(contact);
        submitContactCreation();
        returnToHomePage();
        selectGroupWithoutContact(group);
        selectContact(contact);
        selectAddGroup(group);
        returnToHomePage();

    }

    private void selectGroupWithoutContact(GroupData group) {
        click(By.xpath("//select[@name='group']"));
        new Select(manager.driver.findElement(By.name("group"))).selectByValue("[none]");
    }

    private void selectAddGroup(GroupData group) {
        new Select(manager.driver.findElement(By.name("to_group"))).selectByValue(group.id());
        click(By.xpath("//input[@name='add']"));

    }


    private void selectGroup(GroupData group) {
        new Select(manager.driver.findElement(By.name("new_group"))).selectByValue(group.id());
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
        click(By.linkText("home"));
    }


    public void removeContact(ContactData contact) {
        selectContact(contact);
        removeSelectedContact();
    }

    private void removeSelectedContact() {
        click(By.xpath("//input[@value=\'Delete\']"));
        manager.driver.switchTo().alert().accept();
        returnToHomePage();
    }

    private void selectContact(ContactData contact) {
        click(By.cssSelector(String.format("input[value='%s']", contact.id())));

    }

    private void selectContactToGroup(ContactData contact, GroupData group) {
        click(By.cssSelector(String.format("input[value='%s']", contact.id())));

    }
    public void modifyContact(ContactData contact, ContactData modifiedContact) {
        selectContact(contact);
        initContactModification(contact);
        fillContactForm(modifiedContact);
        submitContactModification();
        returnToHomePage();

    }

    private void submitContactModification() {
        click(By.name("update"));
    }

    private void initContactModification(ContactData contact) {
        click(By.cssSelector(String.format("a[href='edit.php?id=%s']", contact.id())));


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





