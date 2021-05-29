package ru.st.less.addressbook.tests;

import org.testng.annotations.Test;
import ru.st.less.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getContactHelper().editContact();
        app.getContactHelper().fillContactForm(new ContactData("Petr", "Tatarkin", "V", "N", "+7123456789", "ptatarkin@n.ru", "1", "January", "2000", "1", null),false);
        app.getContactHelper().updateContact();
        app.getNavigationHelper().gotoHomePage();
    }
}
