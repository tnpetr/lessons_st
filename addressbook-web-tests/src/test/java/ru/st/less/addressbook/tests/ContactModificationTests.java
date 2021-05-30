package ru.st.less.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.st.less.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoHomePage();
        if (!app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData("Petr",
                    "Tatarkin",
                    "V",
                    "N",
                    "+7123456789",
                    "ptatarkin@n.ru",
                    "1",
                    "January",
                    "2000",
                    "1",
                    "test3"),true);
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().editContact();
        ContactData contact = new ContactData("Petr",
                "Tatarkin",
                "V",
                "N",
                "+7123456789",
                "ptatarkin@n.ru",
                "1",
                "January",
                "2000",
                "1",
                null);
        app.getContactHelper().fillContactForm(contact,false);
        app.getContactHelper().updateContact();
        app.getContactHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),before.size());

        before.remove(before.size() - 1);
        before.add(contact);
        Comparator<? super ContactData> byId = (g1, g2 )-> Integer.compare(g1.getId(),g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
