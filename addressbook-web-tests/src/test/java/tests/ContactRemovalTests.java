package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;


public class ContactRemovalTests extends TestBase {

    @Test
    public void removeContactTests() {
      if (!app.contacts().isContactPresent()) {
        app.contacts().createContact(new ContactData("Test", "Testov", "79788523695","tester@gmail.com"));
      }
      app.contacts().removeContact(app);
    }

}
