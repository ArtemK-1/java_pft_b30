package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;


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
        app.getContactHelper().initContactCreation();
        app.getContactHelper().createContact(contact);
    }
}