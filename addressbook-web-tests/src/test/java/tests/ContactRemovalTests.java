package tests;

import org.junit.jupiter.api.Test;


public class ContactRemovalTests extends TestBase {

    @Test
    public void removeContactTests() {
      if (!app.contacts().isContactPresent()) {
        app.contacts().createContact();
      }
      app.contacts().removeContact(app);
    }

}
