package ru.st.less.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends BaseHelper {

    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void login(String username, String userpassword) {
        type(By.name("user"), username);
        type(By.name("pass"), userpassword);
        click(By.xpath("//input[@value='Login']"));
    }

}
