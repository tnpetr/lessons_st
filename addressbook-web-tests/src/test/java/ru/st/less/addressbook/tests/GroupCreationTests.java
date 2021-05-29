package ru.st.less.addressbook.tests;

import org.testng.annotations.*;
import ru.st.less.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().createGroup(new GroupData("test3", "3", "3"));
  }

}
