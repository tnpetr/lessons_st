package ru.st.less.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.st.less.addressbook.model.ContactData;
import ru.st.less.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0){
            app.contact().create(new ContactData().withFname("Petr")
                    .withLname("Tatarkin")
                    .withMname("V")
                    .withNickname("N")
                    .withMobile("+7123456789")
                    .withEmail("ptatarkin@n.ru")
                    .withBday("1")
                    .withBmonth("January")
                    .withByear("2000")
                    .withTitle("1")
                    .withGroup("test3"),true);
        }
    }

    @Test
    public void testContactModification() {
        Contacts before = app.contact().all();
        ContactData editContact = before.iterator().next();
        ContactData contact = new ContactData().withFname("Petr")
                .withLname("Tatarkin")
                .withMname("V")
                .withNickname("N")
                .withMobile("+7123456789")
                .withEmail("ptatarkin@n.ru")
                .withBday("1")
                .withBmonth("January")
                .withByear("2000")
                .withTitle("1")
                .withId(editContact.getId());
        app.contact().edit(contact);
        Contacts after = app.contact().all();
        assertEquals(after.size(),before.size());
        assertThat(after, equalTo(before.without(editContact).withAdded(contact)));
    }

}
