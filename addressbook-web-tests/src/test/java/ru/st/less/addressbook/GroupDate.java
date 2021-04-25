package ru.st.less.addressbook;

public class GroupDate {
    private final String groupname;
    private final String groupheader;
    private final String groupfooter;

    public GroupDate(String groupname, String groupheader, String groupfooter) {
        this.groupname = groupname;
        this.groupheader = groupheader;
        this.groupfooter = groupfooter;
    }

    public String getGroupname() {
        return groupname;
    }

    public String getGroupheader() {
        return groupheader;
    }

    public String getGroupfooter() {
        return groupfooter;
    }
}
