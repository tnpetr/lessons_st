package ru.st.less.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.st.less.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0){
            app.contact().create(new ContactData().withFname("Petr")
                    .withLname("Tatarkin")
                    .withMname("V")
                    .withNickname("N")
                    .withMobile("+7123456789")
                    .withHomePhone("+7-(192)-00000")
                    .withWorkPhone("186 73")
                    .withEmail("ptatarkin@n.ru")
                    .withBday("1")
                    .withBmonth("January")
                    .withByear("2000")
                    .withTitle("1")
                    .withGroup("test3"),true);
        }
    }

    @Test
    public void testContactPhone() {
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfo = app.contact().infoEditForm(contact);

        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfo)));
    }

    public String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getHomePhone(), contact.getMobile(), contact.getWorkPhone())
                .stream().filter((s) -> ! s.equals(""))
                .map(ContactPhoneTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String phone) {
        return phone.replaceAll("\\s","").replaceAll("[-()]","");
    }

}
