package ru.st.less.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.st.less.addressbook.model.ContactData;
import ru.st.less.addressbook.model.Contacts;

import java.util.List;

public class ContactHelper extends BaseHelper {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitContactCreation() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFname());
        type(By.name("lastname"), contactData.getLname());
        type(By.name("middlename"), contactData.getMname());
        type(By.name("nickname"), contactData.getNickname());
        type(By.name("mobile"), contactData.getMobile());
        type(By.name("home"), contactData.getHomePhone());
        type(By.name("work"), contactData.getWorkPhone());
        type(By.name("email"), contactData.getEmail());
        select(By.name("bday"), contactData.getBday());
        select(By.name("bmonth"), contactData.getBmonth());
        type(By.name("byear"), contactData.getByear());
        type(By.name("title"), contactData.getTitle());
        if (creation) {
            select(By.name("new_group"), contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void newContactLink() {
        click(By.linkText("add new"));
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public void editButton(int id) {
        click(By.cssSelector("a[href='edit.php?id=" + id + "']"));
    }

    public void updateContact() {
        click(By.xpath("(//input[@name='update'])[1]"));
    }

    public void selectContact(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void deleteContact() {
        click(By.xpath("//input[@value='Delete']"));
        wd.switchTo().alert().accept();
    }

    public void create(ContactData contact, boolean b) {
        newContactLink();
        fillContactForm(contact, b);
        submitContactCreation();
        returnToHomePage();
    }

    public void edit(ContactData contact) {
        editButton(contact.getId());
        fillContactForm(contact, false);
        updateContact();
        returnToHomePage();
    }

    public void delete(ContactData contact) {
        selectContact(contact.getId());
        deleteContact();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    private Contacts contactCache = null;

    public Contacts all() {
        if (contactCache != null) {
            return new Contacts();
        }
        Contacts contacts = new Contacts();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            String fname = element.findElement(By.xpath(".//td[3]")).getText();
            String lname = element.findElement(By.xpath(".//td[2]")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
            String fullAddress = element.findElement(By.xpath(".//td[4]")).getText();
            String allEmails = element.findElement(By.xpath(".//td[5]")).getText();
            String allPhones = element.findElement(By.xpath(".//td[6]")).getText();
            ContactData contact = new ContactData().withId(id).withFname(fname).withLname(lname)
                    .withAllPhones(allPhones).withAllEmails(allEmails).withAddress(fullAddress);
            contacts.add(contact);
        }
        return contacts;
    }

    public ContactData infoEditForm(ContactData contact) {
        editButton(contact.getId());
        String fname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lname = wd.findElement(By.name("lastname")).getAttribute("value");
        String homePhohe = wd.findElement(By.name("home")).getAttribute("value");
        String mobilePhohe = wd.findElement(By.name("mobile")).getAttribute("value");
        String workPhohe = wd.findElement(By.name("work")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getText();
        ContactData contactInfo = new ContactData().withId(contact.getId()).withFname(fname).withLname(lname)
                .withHomePhone(homePhohe).withMobile(mobilePhohe).withWorkPhone(workPhohe)
                .withEmail(email).withEmail2(email2).withEmail3(email3).withAddress(address);
        click(By.linkText("home"));
        return contactInfo;
    }
}
