package ru.st.less.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase{
    @Test
    public void testContactDeletion() {
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
    }
}