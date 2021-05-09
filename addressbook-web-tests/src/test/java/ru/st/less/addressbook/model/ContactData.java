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

    public ContactData(String fname, String lname, String mname, String nickname, String mobile, String email, String bday, String bmonth, String byear, String title) {
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
}
