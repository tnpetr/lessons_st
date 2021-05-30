package ru.st.less.addressbook.tests;

import org.testng.annotations.Test;
import ru.st.less.addressbook.model.ContactData;
import ru.st.less.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase{

  @Test
  public void testContactCreation() {
    app.goTo().homePage();
    Contacts before = app.contact().all();
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
            .withGroup("test1");
    app.contact().create(contact,true);
    Contacts after = app.contact().all();
    assertEquals(after.size(),before.size() + 1);
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt(c -> c.getId()).max().getAsInt()))));
  }

}
