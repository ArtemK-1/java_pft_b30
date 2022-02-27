package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;


public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation(){
        ContactData contact = new ContactData(
                "Ivan",
                "Ivanov",
                "iv",
                "+79001230001",
                "mail@mail.ru",
                "test1");
        app.getNavigationHelper().gotoGroupPage();
        if (! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupData(contact.getGroup(), null, null));
        }
        app.getNavigationHelper().gotoHomePage();
        int before = app.getContactHelper().getContactCount();
//        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().initContactCreation();
        app.getContactHelper().createContact(contact);
        app.getNavigationHelper().gotoHomePage();
        /*List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);*/
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before + 1);
    }
}