package ru.st.less.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.st.less.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase{
    @Test
    public void testContactDeletion() {
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
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),before.size() - 1);

        before.remove(before.size()-1);
        Assert.assertEquals(before, after);
    }
}
