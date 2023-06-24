package ru.stqa.pftester.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pftester.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase{





    @Test
    public void testContactCreation() throws Exception {

        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData("Test", "Testov", "78005678930", "tester@gmail.com", "test1"), true);
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToContactPage();
    }


}