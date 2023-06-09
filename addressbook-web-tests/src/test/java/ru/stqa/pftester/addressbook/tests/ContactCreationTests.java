package ru.stqa.pftester.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pftester.addressbook.model.ContactData;
import ru.stqa.pftester.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase{

    @Test(enabled = false)
    public void testContactCreation() throws Exception {
        if (!app.group().isThereAGroup()) {
            app.group().create(new GroupData().withName("test1"));
        }
        app.goTo().groupPage();
        GroupData group = new GroupData().withName("test2");
        app.group().create(group);
        app.getContactHelper().returnToContactPage();

        List<ContactData> before = app.getContactHelper().getContactList();
        ContactData contact = new ContactData("Avatar", "Avatarovich", "78005678930", "tester@gmail.com", "test1");
        app.getContactHelper().createContact(contact);
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(contact);
        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);

    }


}