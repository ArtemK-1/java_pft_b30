package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDataTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().HomePage();
        if (app.contact().all().size() ==0){
            app.contact().createContact(new ContactData()
                    .withFirstName("Petr")
                    .withLastName("Petrov")
                    .withAddress("moscow city 123")
                    .withHomePhone("+7123")
                    .withMobilePhone("74-56")
                    .withWorkPhone("77 89")
                    .withPhone2("2222")
                    .withEmail("test@ya.ru")
                    .withEmail2("test2@ya.ru")
                    .withEmail3("test3@ya.ru"));
        }
    }

    @Test
    public void testContactAddress() {
        app.goTo().HomePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().InfoFromEditForm(contact);

        assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
    }

    @Test
    public void testContactPhones(){
        app.goTo().HomePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().InfoFromEditForm(contact);

        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    }

    @Test
    public void testEmails() {
        app.goTo().HomePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().InfoFromEditForm(contact);

        assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
    }

    private String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone(), contact.getPhone2())
                .stream().filter((e) -> ! e.equals(""))
                .map(ContactDataTests::cleanedPhones)
                .collect(Collectors.joining("\n"));
    }

    public static String cleanedPhones(String phone){
        return phone.replaceAll("\\s","").replaceAll("[-()]","");
    }

    private String mergeEmails(ContactData contact) {
        return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
                .stream().filter((e) -> !e.equals(""))
                .collect(Collectors.joining("\n"));
    }
}