package ru.st.less.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase{

  @Test
  public void testContactCreation() {
    newContactLink();
    fillContactForm(new ContactData("Petr", "Tatarkin", "V", "N", "+7123456789", "ptatarkin@n.ru", "1", "January", "2000", "1"));
    submitContactCreation();
    returnToHomePage();
  }

}
