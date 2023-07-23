package ru.stqa.pftester.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pftester.addressbook.model.ContactData;
import ru.stqa.pftester.addressbook.model.Contacts;
import ru.stqa.pftester.addressbook.model.GroupData;
import ru.stqa.pftester.addressbook.model.Groups;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData().withFirstName("Avatar").withLastName("Avatarovich").withMobile("78005678930").withEmail("tester@gmail.com").withGroup("test1"));
        }
    }

    @Test
    public void testContactDeletion() {





        Contacts before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        app.contact().returnToContactPage();
        Contacts after = app.contact().all();
        assertEquals(after.size(), before.size() - 1);

        assertThat(after, equalTo(before.without(deletedContact)));
    }

}


