package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Set;

public class ContactModificationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().HomePage();
        if (app.contact().all().size() ==0){
            app.contact().createContact(new ContactData().withFirstName("Ivan").withLastName("Ivanov")
                            .withNickName("iv").withHomePhone("+79001230001").withEmail("mail@mail.ru"));
        }
    }

    @Test
    public void testContactModification(){
        app.goTo().HomePage();
        Set<ContactData> before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstName("Petrov")
                .withLastName("Petrov").withNickName("iv").withHomePhone("+79001230009").withEmail("mail@mail.ru")
                .withGroup("test1");
        app.contact().modify(contact);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size());

        before.remove(modifiedContact);
        before.add(contact);
        Assert.assertEquals(before, after);
    }
}