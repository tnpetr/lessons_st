package ru.st.less.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.st.less.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTests extends TestBase {

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
                    .withAddress("sdadsadsdasdasdsdadfdfdasfgwerjhl;kfldsafdsfdsjf;dsf;j;dsfj;ds.\nadfadsfsafadsfdsf\nadfsdfsfdsfdfdf.\ndfadsf")
                    .withEmail("ptatarkin@n.ru")
                    .withEmail2("ptatarkin@n.ru")
                    .withEmail3("ptatarkin@n.ru")
                    .withBday("1")
                    .withBmonth("January")
                    .withByear("2000")
                    .withTitle("1")
                    .withGroup("test3"),true);
        }
    }

    @Test
    public void testContactAddress() {
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfo = app.contact().infoEditForm(contact);

        assertThat(contact.getAddress(), equalTo(contactInfo.getAddress()));
    }

    public String mergeEmails(ContactData contact) {
        return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
                .stream().filter((s) -> ! s.equals(""))
                .collect(Collectors.joining("\n"));
    }
}
