package ru.stqa.pftester.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pftester.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Test", "Testov", "78005678930", "tester@gmail.com", "test1"), true);
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectContact();
        app.getContactHelper().closeAssertConfirmation();

    }

}
