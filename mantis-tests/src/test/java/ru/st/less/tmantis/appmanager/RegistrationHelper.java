package ru.st.less.tmantis.appmanager;


import org.openqa.selenium.By;

public class RegistrationHelper extends BaseHelper {

    public RegistrationHelper(ApplicationManager app) {
        super(app);
    }

    public void start(String username, String email) {
        wd.get(app.getProperty("web.baseUrl") + "signup_page.php");
        type(By.name("username"), username);
        type(By.name("email"), email);
        //click(By.xpath("//input[@value='Зарегистрироваться']"));
        click(By.xpath("//span[@class='submit-button']")); //У меня по другому WebDriver не смог кликнуть по кнопке
        //click(By.cssSelector("input[value='Зарегистрироваться']"));
    }

    public void finish(String confirmationLink, String password) {
        wd.get(confirmationLink);
        type(By.name("password"), password);
        type(By.name("password_confirm"), password);
        click(By.xpath("//span[@class='submit-button']")); //Тоже срабатывает только при нажатии на область разметки
        //click(By.cssSelector("input[value='Update User']"));

    }


}
