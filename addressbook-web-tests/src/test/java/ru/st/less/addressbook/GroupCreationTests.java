package ru.st.less.addressbook;

import org.testng.annotations.*;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("test3", "3", "3"));
    submitGroupCreation();
    returnToGroupPage();
  }

}
