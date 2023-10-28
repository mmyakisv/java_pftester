package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import tests.TestBase;

import java.util.ArrayList;
import java.util.List;


public class ContactCreationTests extends TestBase {

    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>();
        for (var firstname : List.of("", "Test")) {
            for (var lastname : List.of("", "Testov")) {
                for (var mobile : List.of("", "79788523695")) {
                    for (var email : List.of("", "tester@gmail.com")) {

                        result.add(new ContactData(firstname, lastname, mobile, email));
                    }
                }
            }
        }
        for (int i = 0; i < 5; i++) {

            result.add(new ContactData(randomString(i * 10), randomString(i * 10), randomString(i * 10), randomString(i * 10)));
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")

    public void contactCreationTests(ContactData contact) {
        int contactCount = app.contacts().getCount();
        app.contacts().createContact(contact);
        int newContactCount = app.contacts().getCount();
        Assertions.assertEquals(contactCount + 1, newContactCount);
    }
}



