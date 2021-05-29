package ru.st.less.addressbook.tests;

import org.testng.annotations.Test;
import ru.st.less.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase{

  @Test
  public void testContactCreation() {
    app.getContactHelper().newContactLink();
    app.getContactHelper().fillContactForm(new ContactData("Petr", "Tatarkin", "V", "N", "+7123456789", "ptatarkin@n.ru", "1", "January", "2000", "1", "test3"),true);
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().gotoHomePage();
  }

}
