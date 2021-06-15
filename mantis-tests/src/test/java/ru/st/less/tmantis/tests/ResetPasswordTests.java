package ru.st.less.tmantis.tests;

import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.st.less.tmantis.model.MailMessage;
import ru.st.less.tmantis.model.UserData;
import ru.st.less.tmantis.model.Users;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ResetPasswordTests extends TestBase{

    @Test
    public void resetPasswordTest() throws InterruptedException, MessagingException, IOException {

        Users users = app.db().users();
        users.removeIf(g -> g.getUsername().equals("administrator"));
        UserData user = users.iterator().next();
        app.admin().resetPasswordForUser(user);
        String email = user.getEmail();
        String userName = user.getUsername();
        System.out.println(userName);
        String password = "password";
//        app.james().createUser(userName, password);
        List<MailMessage> mailMessages = app.james().waitForMail(userName, password, 60000);
        String confirmationLink = findConfirmationLink(mailMessages, email);
        app.user().changePassword(confirmationLink, "newPassword");
        assertTrue(app.newSession().login(userName, password));
    }

    private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }


}
