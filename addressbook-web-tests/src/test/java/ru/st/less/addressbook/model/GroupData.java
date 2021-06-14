package ru.st.less.addressbook.model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "group_list")
public class GroupData {

    @Id
    @Column(name = "group_id")
    private int id = Integer.MAX_VALUE;
    @Expose
    @Column(name = "group_name")
    private String groupname;

    @ManyToMany(mappedBy = "groups", fetch = FetchType.EAGER)
    private Set<ContactData> contacts = new HashSet<>();

    @Expose
    @Column(name = "group_header")
    @Type(type = "text")
    private String groupheader;
    @Expose
    @Column(name = "group_footer")
    @Type(type = "text")
    private String groupfooter;

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

        if (id != groupData.id) return false;
        if (groupname != null ? !groupname.equals(groupData.groupname) : groupData.groupname != null) return false;
        if (groupheader != null ? !groupheader.equals(groupData.groupheader) : groupData.groupheader != null)
            return false;
        return groupfooter != null ? groupfooter.equals(groupData.groupfooter) : groupData.groupfooter == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (groupname != null ? groupname.hashCode() : 0);
        result = 31 * result + (groupheader != null ? groupheader.hashCode() : 0);
        result = 31 * result + (groupfooter != null ? groupfooter.hashCode() : 0);
        return result;
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

    public Contacts getContacts() {
        return new Contacts(contacts);
    }
}
