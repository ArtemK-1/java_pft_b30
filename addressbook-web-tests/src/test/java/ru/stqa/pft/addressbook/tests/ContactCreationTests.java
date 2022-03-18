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
        ContactData contact = new ContactData()
                .withFirstName("Андрей").withLastName("Куликов")
                .withNickName("iv").withHomePhone("+79001230001")
                .withEmail("mail@mail.ru").withGroup("test1");

        if (app.group().all().size() == 0){
            app.group().create(new GroupData().withName(contact.getGroup()));
        }
        app.goTo().HomePage();
        Contacts before = app.contact().all();
        app.contact().create(contact);
        Contacts after = app.contact().all();
        assertEquals(after.size(), before.size() + 1);
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }
}