package ru.st.less.tmantis.tests;

import org.testng.annotations.Test;
import ru.st.less.tmantis.appmanager.HttpSession;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class LoginTests extends TestBase{

    @Test
    public void testLogin() throws IOException {
        HttpSession session = app.newSession();
        assertTrue(session.login("user1623762591748","password"));
        assertTrue(session.isLoggedInAs("user1623762591748"));
    }
}
