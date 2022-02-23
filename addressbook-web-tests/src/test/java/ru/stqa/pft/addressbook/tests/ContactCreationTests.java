package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;


public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation(){
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData(
                "Ivan",
                "Ivanov",
                "iv",
                "+79001230001",
                "mail@mail.ru",
                "test1"), true);
        app.getContactHelper().saveContact();
    }

}