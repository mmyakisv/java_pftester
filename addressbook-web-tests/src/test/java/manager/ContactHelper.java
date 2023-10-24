package manager;

import model.ContactData;
import model.GroupData;
import org.openqa.selenium.By;

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
        //manager.driver.findElement(By.name("firstname")).click();
        //manager.driver.findElement(By.name("firstname")).sendKeys("Test");
        //manager.driver.findElement(By.name("lastname")).click();
        //manager.driver.findElement(By.name("lastname")).sendKeys("Testov");
        //manager.driver.findElement(By.name("mobile")).click();
        //manager.driver.findElement(By.name("mobile")).sendKeys("79788523695");
        //manager.driver.findElement(By.name("email")).click();
        //manager.driver.findElement(By.name("email")).sendKeys("tester@gmail.com");

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


    public void removeContact(ApplicationManager manager) {
        selectContact();
        removeSelectedContact();
    }

    private void removeSelectedContact() {
        click(By.xpath("//input[@value=\'Delete\']"));
        manager.driver.switchTo().alert().accept();
    }

    private void selectContact() {
        click(By.name("selected[]"));
    }
}