package ru.st.less.rest;

import org.testng.SkipException;
import java.io.IOException;

public class TestBase {

    public boolean isIssueOpen(int issueId) throws IOException {
        String status = RestTests.getIssueStatus(issueId);
        System.out.println(status);
        return status.equals("Resolved");
    }

    public void skipIfNotFixed(int issueId) throws IOException {
        if (isIssueOpen(issueId)) {
            throw new SkipException("Ignored because of issue " + issueId);
        }
    }

}
