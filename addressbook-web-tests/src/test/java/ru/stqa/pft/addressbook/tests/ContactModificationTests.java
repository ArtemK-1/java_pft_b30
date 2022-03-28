package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        if (app.db().contacts().size() == 0){
            app.goTo().HomePage();
            app.contact().createContact(new ContactData()
                            .withFirstName("Ivan")
                            .withLastName("Ivanov")
                            .withNickName("iv")
                            .withAddress("address")
                            .withHomePhone("+79001230001")
                            .withMobilePhone("300")
                            .withWorkPhone("+790")
                            .withPhone2("00-00")
                            .withEmail("mail@mail.ru")
                            .withEmail2("mail2@mail.ru")
                            .withEmail3("mail3@mail.ru"));
        }
    }

    @Test
    public void testContactModification(){
        Contacts before = app.db().contacts();
        app.goTo().HomePage();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId())
                .withFirstName("Ivan2")
                .withLastName("Ivanov3")
                .withNickName("iv4")
                .withAddress("address3")
                .withHomePhone("+790012301")
                .withMobilePhone("320")
                .withWorkPhone("+750")
                .withPhone2("00-002")
                .withEmail("mail@ya.ru")
                .withEmail2("mail2@ya.ru")
                .withEmail3("mail3@ya.ru");
        app.contact().modify(contact);
        assertEquals(app.contact().count(), before.size());
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
        verifyContactListInUI();
    }
}