package ru.st.less.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.st.less.addressbook.model.ContactData;
import ru.st.less.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTests extends TestBase{

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
                    .withAddress("asddsad")
                    .withGroup("test1"),true);
        }
    }

    @Test
    public void testContactDeletion() {
        Contacts before = app.db().contacts();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        app.goTo().homePage();
        assertEquals(app.contact().count(),before.size() - 1);
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.without(deletedContact)));
    }

}
