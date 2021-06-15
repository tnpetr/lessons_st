package ru.st.less.tmantis.appmanager;

import org.openqa.selenium.By;

public class UserHelper extends BaseHelper{

    public UserHelper(ApplicationManager app) {
        super(app);
    }

    public void changePassword(String confirmationLink, String password) {
        wd.get(confirmationLink);
        type(By.name("password"), password);
        type(By.name("password_confirm"), password);
        click(By.xpath("//span[@class='submit-button']"));
    }
}
