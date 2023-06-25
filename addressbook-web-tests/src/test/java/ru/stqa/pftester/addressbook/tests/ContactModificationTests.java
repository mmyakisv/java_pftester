package ru.stqa.pftester.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pftester.addressbook.model.ContactData;
import ru.stqa.pftester.addressbook.model.GroupData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Test", "Testov", "78005678930", "tester@gmail.com", "test1"), true);
        }

        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("Avatar", "Avatarovich", "78005678930", "tester@gmail.com", null), false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToContactPage();

    }
}
