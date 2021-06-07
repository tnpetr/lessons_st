package ru.st.less.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.st.less.addressbook.appmanager.ApplicationManager;

import java.io.IOException;

public class TestBase {

    protected static final ApplicationManager app
            = new ApplicationManager(System.getProperty("browser", BrowserType.IE));

    @BeforeSuite
    public void setUp() throws IOException {
        app.init();
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }

}
