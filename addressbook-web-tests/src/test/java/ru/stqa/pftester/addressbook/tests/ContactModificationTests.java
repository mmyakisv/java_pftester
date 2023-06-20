package ru.stqa.pftester.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pftester.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("Avatar", "Avatarovich", "78005678930", "tester@gmail.com"));
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToContactPage();

    }
}
