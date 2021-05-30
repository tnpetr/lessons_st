package ru.st.less.addressbook.model;

public class ContactData {
    private final String fname;
    private final String lname;
    private final String mname;
    private final String nickname;
    private final String mobile;
    private final String email;
    private final String bday;
    private final String bmonth;
    private final String byear;
    private final String title;
    private String group;
    private int id;

    public ContactData(String fname, String lname, String mname, String nickname, String mobile, String email, String bday, String bmonth, String byear, String title, String group ) {
        this.id = Integer.MAX_VALUE;
        this.fname = fname;
        this.lname = lname;
        this.mname = mname;
        this.nickname = nickname;
        this.mobile = mobile;
        this.email = email;
        this.bday = bday;
        this.bmonth = bmonth;
        this.byear = byear;
        this.title = title;
        this.group = group;
    }

    public ContactData(int id, String fname, String lname ) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.mname = "";
        this.nickname = "";
        this.mobile = "";
        this.email = "";
        this.bday = "";
        this.bmonth = "";
        this.byear = "";
        this.title = "";
        this.group = "";
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getMname() {
        return mname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getBday() {
        return bday;
    }

    public String getBmonth() {
        return bmonth;
    }

    public String getByear() {
        return byear;
    }

    public String getTitle() {
        return title;
    }

    public String getGroup() {
        return group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (fname != null ? !fname.equals(that.fname) : that.fname != null) return false;
        return lname != null ? lname.equals(that.lname) : that.lname == null;
    }

    @Override
    public int hashCode() {
        int result = fname != null ? fname.hashCode() : 0;
        result = 31 * result + (lname != null ? lname.hashCode() : 0);
        return result;
    }
}
