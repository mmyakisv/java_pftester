package ru.stqa.pftester.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pftester.addressbook.model.ContactData;
import ru.stqa.pftester.addressbook.model.GroupData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Test", "Testov", "78005678930", "tester@gmail.com", "test1"));
        }

        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().deleteSelectContact();
        app.getContactHelper().closeAssertConfirmation();
        app.getContactHelper().returnToContactPage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);

    }

}
