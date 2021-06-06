package ru.st.less.addressbook.tests;

import org.testng.annotations.Test;
import ru.st.less.addressbook.model.ContactData;
import ru.st.less.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTests extends TestBase{

  @Test
  public void testContactCreation() {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/photo.png");
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
            .withGroup("test1")
            .withPhoto(photo);
    app.contact().create(contact,true);
    assertEquals(app.contact().count(),before.size() + 1);
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt(c -> c.getId()).max().getAsInt()))));
  }

}
