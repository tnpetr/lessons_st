package ru.st.less.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.st.less.addressbook.model.GroupData;
import ru.st.less.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (app.db().groups().size() == 0) {
            app.group().create(new GroupData().withGroupname("test3"));
        }
    }

    @Test
    public void testGroupModification() {
        Groups before = app.db().groups();
        GroupData midifiedGroup = before.iterator().next();
        GroupData group = new GroupData().withId(midifiedGroup.getId())
                .withGroupname("test1")
                .withGroupheader("3")
                .withGroupfooter("3");
        app.group().modify(group);
        assertEquals(app.group().count(), before.size());
        Groups after = app.db().groups();
        assertThat(after, equalTo(before.without(midifiedGroup).withAdded(group)));
    }

}
