package ru.stqa.pftester.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pftester.addressbook.model.ContactData;
import ru.stqa.pftester.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() throws Exception {
        app.getContactHelper().returnToContactPage();

        Contacts before = app.contact().all();

        ContactData contact = new ContactData().withFirstName("Avatar").withLastName("Avatarovich").withEmail("tester@gmail.com").withMobile("7852666425");
        app.contact().create(contact);
        app.getContactHelper().returnToContactPage();
        Contacts after = app.contact().all();


        assertThat(after.size(), equalTo(before.size() + 1));

        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

    }


}