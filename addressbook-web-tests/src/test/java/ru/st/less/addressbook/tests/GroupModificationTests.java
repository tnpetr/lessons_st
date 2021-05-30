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
        if (app.group().all().size() == 0){
            app.group().create(new GroupData().withGroupname("test3"));
        }
    }

    @Test
    public void testGroupModification() {
        Groups before = app.group().all();
        GroupData midifiedGroup = before.iterator().next();
        GroupData group = new GroupData().withId(midifiedGroup.getId())
                .withGroupname("test1")
                .withGroupheader("3")
                .withGroupfooter("3");
        app.group().modify(group);
        Groups after = app.group().all();
        assertEquals(after.size(),before.size());
        assertThat(after, equalTo(before.without(midifiedGroup).withAdded(group)));
    }

}
