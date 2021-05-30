package ru.st.less.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.st.less.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase{

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
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
            "test3");
    app.getContactHelper().createContact(contact,true);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size() + 1);

    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2 )-> Integer.compare(g1.getId(),g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
