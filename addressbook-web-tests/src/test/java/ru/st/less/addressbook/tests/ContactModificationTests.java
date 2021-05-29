package ru.st.less.addressbook.tests;

import org.testng.annotations.Test;
import ru.st.less.addressbook.model.ContactData;
import ru.st.less.addressbook.model.GroupData;

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
        app.getContactHelper().editContact();
        app.getContactHelper().fillContactForm(new ContactData("Petr",
                "Tatarkin",
                "V",
                "N",
                "+7123456789",
                "ptatarkin@n.ru",
                "1",
                "January",
                "2000",
                "1",
                null),false);
        app.getContactHelper().updateContact();
        app.getContactHelper().returnToHomePage();
    }
}
