package ru.stqa.pftester.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pftester.addressbook.model.ContactData;
import ru.stqa.pftester.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() throws Exception {

        Contacts before = app.contact().all();

        ContactData contact = new ContactData()
                .withFirstName("Avatar").withLastName("Avatarovich").withMobile("7852666425").withEmail("tester@gmail.com");
        app.contact().create(contact);
        Contacts after = app.contact().all();


        assertThat(after.size(), equalTo(before.size() + 1));

        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

    }


}