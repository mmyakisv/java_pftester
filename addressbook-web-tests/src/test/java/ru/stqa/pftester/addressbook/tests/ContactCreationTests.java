package ru.stqa.pftester.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pftester.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase{





    @Test
    public void testContactCreation() throws Exception {

        app.initContactCreation();
        app.fillContactForm(new ContactData("Test", "Testov", "78005678930", "tester@gmail.com"));
        app.submitContactCreation();
        app.returnToContactPage();
        app.logout();
    }


}