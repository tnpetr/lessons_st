package ru.st.less.tmantis.appmanager;

import org.openqa.selenium.By;
import ru.st.less.tmantis.model.UserData;

import java.io.IOException;

public class AdminHelper extends BaseHelper{
    public AdminHelper(ApplicationManager app) {
        super(app);
    }

    public void resetPasswordForUser(UserData user) throws IOException {
        HttpSession session = app.newSession();
        login("administrator", "root");
        click(By.cssSelector("a[href=\"/mantisbt-1.3.20/manage_overview_page.php\""));
        click(By.cssSelector("a[href=\"/mantisbt-1.3.20/manage_user_page.php\""));
        click(By.cssSelector("a[href=\"manage_user_edit_page.php?user_id=" + user.getId() + "\""));
        click(By.cssSelector("form[id=\"manage-user-reset-form\"]"));
        //click(By.xpath("//span/input[@value='Сбросить пароль']"));
    }

    private void login(String username, String password) {
        wd.get(app.getProperty("web.baseUrl") + "login.php");
        type(By.name("username"), username);
        type(By.name("password"), password);
        click(By.xpath("//span[@class='submit-button']"));
    }


}
