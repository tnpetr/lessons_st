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

public class RemoveContactToGroupTests extends TestBase{

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
    public void testContactOutGroup() {
        app.goTo().homePage();
        Groups groups = app.db().groups();
        Contacts contacts = app.db().contacts();
        boolean createLink = false;
        for (GroupData group : groups) {
            Contacts contactWithGroups = group.getContacts();
            if (contactWithGroups.size() > 0) {
                ContactData contact = contactWithGroups.iterator().next();
                GroupData afterGroupDB = removedContactToGroup(contact, group);
                assertEquals(afterGroupDB.getContacts().size(), contactWithGroups.size() - 1);
                assertThat(afterGroupDB.getContacts(), equalTo(contacts));
                break;
            } else {
                createLink = true;
            }
        }
        if (createLink) {
            ContactData contact = contacts.iterator().next();
            GroupData group = groups.iterator().next();
            app.contact().addContactToGroup(contact, group);
            Contacts contactWithGroups = group.getContacts();
            GroupData afterGroupDB = removedContactToGroup(contact, group);
            assertEquals(afterGroupDB.getContacts().size(), contactWithGroups.size() - 1);
            assertThat(afterGroupDB.getContacts(), equalTo(contacts));
        }
    }

    private GroupData removedContactToGroup(ContactData contact, GroupData group) {
        app.contact().removeContactToGroup(contact, group);
        GroupData afterGroupDB = app.db().findGroup(group.getId());
        return afterGroupDB;
    }
}
