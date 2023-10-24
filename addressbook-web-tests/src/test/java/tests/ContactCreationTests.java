package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Test;
import tests.TestBase;


public class ContactCreationTests extends TestBase {

    @Test
    public void contactCreationTests() {
        app.contacts().createContact(new ContactData("Test", "Testov", "79788523695","tester@gmail.com"));
    }

}
