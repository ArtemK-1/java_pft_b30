package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import java.util.Set;


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
        Set<ContactData> before = app.contact().all();
        app.contact().create(contact);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() + 1);

        contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before, after);
    }
}