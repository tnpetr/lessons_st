package ru.st.less.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.st.less.addressbook.model.ContactData;
import ru.st.less.addressbook.model.Contacts;
import ru.st.less.addressbook.model.GroupData;
import ru.st.less.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class AddContactToGroupTests extends TestBase{

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

    @Test
    public void testContactInGroup() {
        app.goTo().homePage();
        Groups groups = app.db().groups();
        Contacts contacts = app.db().contacts();
        boolean create = false;
        for (ContactData contact : contacts) {
            Groups groupWithContacts = contact.getGroups();
            groups.removeAll(groupWithContacts);
            if (groups.size() > 0) {
                GroupData group = groups.iterator().next();
                addedContactToGroup(contact, group);
                break;
            } else {
                create = true;
            }
        }
        if (create){
            GroupData newGroup = new GroupData().withGroupname("test");
            app.group().create(newGroup);
            Groups newGroups = app.db().groups();
            GroupData group = app.db().findGroup(newGroups.stream().mapToInt((g) -> g.getId()).max().getAsInt());
            ContactData contact = contacts.iterator().next();
            addedContactToGroup(contact, group);
        }
    }

    public void addedContactToGroup(ContactData contact, GroupData group) {
        app.contact().addContactToGroup(contact, group);
        ContactData afterContactDB = app.db().findContact(contact.getId());
        assertEquals(afterContactDB.getGroups().size(), contact.getGroups().size() + 1);
        assertThat(afterContactDB, equalTo(contact));
    }

}
