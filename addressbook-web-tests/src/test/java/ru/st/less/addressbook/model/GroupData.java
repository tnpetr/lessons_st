package ru.st.less.addressbook.model;

public class GroupData {

    private int id = Integer.MAX_VALUE;
    private String groupname;
    private String groupheader;
    private String groupfooter;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupData groupData = (GroupData) o;

        if (id != groupData.id) return false;
        return groupname != null ? groupname.equals(groupData.groupname) : groupData.groupname == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (groupname != null ? groupname.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "id='" + id + '\'' +
                ", groupname='" + groupname + '\'' +
                '}';
    }

    public GroupData withId(int id) {
        this.id = id;
        return this;
    }

    public GroupData withGroupname(String groupname) {
        this.groupname = groupname;
        return this;
    }

    public GroupData withGroupheader(String groupheader) {
        this.groupheader = groupheader;
        return this;
    }

    public GroupData withGroupfooter(String groupfooter) {
        this.groupfooter = groupfooter;
        return this;
    }

    public int getId() {
        return id;
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
