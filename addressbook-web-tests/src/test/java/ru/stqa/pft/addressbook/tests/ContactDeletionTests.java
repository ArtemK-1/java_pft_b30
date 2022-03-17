package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().HomePage();
        if (!app.contact().isThereAContact()){
            app.contact().createContact(new ContactData(
                    "Ivan",
                    "Ivanov",
                    "iv",
                    "+79001230001",
                    "mail@mail.ru",
                    null));
        }
    }

    @Test
    public void testContactDeletion(){
        app.goTo().HomePage();
        List<ContactData> before = app.contact().list();
        app.contact().select(before.size() - 1);
        app.contact().delete();
        app.goTo().HomePage();
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size()-1);
        Assert.assertEquals(before, after);
    }
}