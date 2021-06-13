package ru.st.less.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.st.less.addressbook.model.ContactData;
import ru.st.less.addressbook.model.Contacts;
import ru.st.less.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactToGroupTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.db().contacts().size() == 0){
            app.contact().create(new ContactData().withFname("Petr")
                    .withLname("Tatarkin")
                    .withMobile("+7123456789")
                    .withHomePhone("+7123456789")
                    .withWorkPhone("+7123456789")
                    .withEmail("ptatarkin@n.ru")
                    .withEmail2("ptatarkin@n.ru")
                    .withEmail3("ptatarkin@n.ru")
                    .withAddress("asddsad"),true);
        }
        app.goTo().groupPage();
        if (app.db().groups().size() == 0){
            app.group().create(new GroupData().withGroupname("test3"));
        }
    }

    @Test(enabled = false)
    public void testContactInGroup() {
        ContactData contact = app.db().contacts().iterator().next();
        ContactData beforeContactDB = app.db().findContact(contact.getId());
        GroupData group = app.db().groups().iterator().next();
        app.contact().addContactToGroup(contact, group);
        ContactData afterContactDB = app.db().findContact(contact.getId());
        assertEquals(afterContactDB.getGroups().size(),beforeContactDB.getGroups().size() + 1);
        assertThat(afterContactDB, equalTo(beforeContactDB));
    }

    @Test
    public void testContactOutGroup() {
        app.goTo().homePage();
        ContactData contact = app.db().contacts().iterator().next();
        ContactData beforeContactDB = app.db().findContact(contact.getId());
        GroupData group = app.db().groups().iterator().next();
        app.contact().removeContactToGroup(contact, group);
        ContactData afterContactDB = app.db().findContact(contact.getId());
        assertEquals(afterContactDB.getGroups().size(),beforeContactDB.getGroups().size() - 1);
        assertThat(afterContactDB, equalTo(beforeContactDB));
    }
}
