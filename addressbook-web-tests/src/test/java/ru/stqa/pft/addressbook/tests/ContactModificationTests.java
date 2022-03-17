package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().HomePage();
        if (!app.contact().isThereAContact()){
            app.contact().createContact(new ContactData().withFirstName("Ivan").withLastName("Ivanov")
                            .withNickName("iv").withHomePhone("+79001230001").withEmail("mail@mail.ru"));
        }
    }

    @Test
    public void testContactModification(){
        app.goTo().HomePage();
        List<ContactData> before = app.contact().list();
        int index = before.size() -1;
        ContactData contact = new ContactData().withId(before.get(before.size() -1).getId()).withFirstName("Petrov")
                .withLastName("Petrov").withNickName("iv").withHomePhone("+79001230009").withEmail("mail@mail.ru")
                .withGroup("test1");
        app.contact().modify(index, contact);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);
        Comparator<? super ContactData> byID = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byID);
        after.sort(byID);
        Assert.assertEquals(before, after);
    }
}