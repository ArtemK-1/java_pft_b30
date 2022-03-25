package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class ContactCreationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().GroupPage();
    }

    @Test
    public void testContactCreation(){
        ContactData contact = new ContactData().withFirstName("Petr").withLastName("Petrov")
                .withAddress("moscow city 123").withHomePhone("+7123").withMobilePhone("+7456")
                .withWorkPhone("+7789").withEmail("test@ya.ru");

        if (app.group().all().size() == 0){
            app.group().create(new GroupData().withName(contact.getGroup()));
        }
        app.goTo().HomePage();
        Contacts before = app.contact().all();
        app.contact().create(contact);
        assertEquals(app.contact().count(), before.size() + 1);
        Contacts after = app.contact().all();
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }
}