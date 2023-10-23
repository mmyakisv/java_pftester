package tests;

import org.junit.jupiter.api.Test;
import tests.TestBase;


public class ContactCreationTests extends TestBase {

    @Test
    public void contactCreationTests() {
        app.contacts().createContact();
    }

}
