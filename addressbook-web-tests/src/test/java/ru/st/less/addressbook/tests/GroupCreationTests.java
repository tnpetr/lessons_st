package ru.st.less.addressbook.tests;

import org.testng.annotations.*;
import ru.st.less.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.gotoGroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("test3", "3", "3"));
    app.submitGroupCreation();
    app.returnToGroupPage();
  }

}
