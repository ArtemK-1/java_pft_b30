package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTests extends TestBase{

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
    public void testContactDeletion(){
        Contacts before = app.db().contacts();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        app.goTo().HomePage();
        assertEquals(app.contact().count(), before.size() -1);
        Contacts after = app.db().contacts();
        MatcherAssert.assertThat(after, equalTo(before.without(deletedContact)));
    }
}