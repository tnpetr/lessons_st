package ru.st.less.addressbook.model;

public class GroupData {

    private int id;
    private final String groupname;
    private final String groupheader;
    private final String groupfooter;

    public GroupData(String groupname, String groupheader, String groupfooter) {
        this.id = Integer.MAX_VALUE;
        this.groupname = groupname;
        this.groupheader = groupheader;
        this.groupfooter = groupfooter;
    }
    public GroupData(int id, String groupname, String groupheader, String groupfooter) {
        this.id = id;
        this.groupname = groupname;
        this.groupheader = groupheader;
        this.groupfooter = groupfooter;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "id='" + id + '\'' +
                ", groupname='" + groupname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupData groupData = (GroupData) o;

        return groupname != null ? groupname.equals(groupData.groupname) : groupData.groupname == null;
    }

    @Override
    public int hashCode() {
        return groupname != null ? groupname.hashCode() : 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
