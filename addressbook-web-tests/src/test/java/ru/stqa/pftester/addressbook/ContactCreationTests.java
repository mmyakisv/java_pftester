package ru.stqa.pftester.addressbook;

import org.testng.annotations.*;

public class ContactCreationTests extends TestBase{





    @Test
    public void testContactCreation() throws Exception {

        initContactCreation();
        fillContactForm(new ContactData("Test", "Testov", "78005678930", "tester@gmail.com"));
        submitContactCreation();
        returnToContactPage();
        logout();
    }


}