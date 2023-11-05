package tests;

import common.commonFunctions;
import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class ContactCreationTests extends TestBase {

    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>();
        for (var firstname : List.of("", "Test")) {
            for (var lastname : List.of("", "Testov")) {
                for (var mobile : List.of("", "79788523695")) {
                    for (var email : List.of("", "tester@gmail.com")) {

                        result.add(new ContactData()
                                .withFirstname(firstname)
                                .withLastname(lastname)
                                .withMobile(mobile)
                                .withEmail(email));
                    }
                }
            }
        }
        for (int i = 0; i < 5; i++) {

            result.add(new ContactData()
                    .withFirstname(commonFunctions.randomString(i * 10))
                    .withLastname(commonFunctions.randomString(i * 10))
                    .withMobile(commonFunctions.randomString(i * 10))
                    .withEmail(commonFunctions.randomString(i * 10)));
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")

    public void contactCreationTests(ContactData contact) {
        var oldContacts = app.contacts().getList();
        app.contacts().createContact(contact);
        var newContacts = app.contacts().getList();

        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);

        var expectedList = new ArrayList<>(oldContacts);
        expectedList.add(contact.withId(newContacts.get(newContacts.size() - 1).id()).withMobile("").withEmail(""));
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts, expectedList);
    }
}



