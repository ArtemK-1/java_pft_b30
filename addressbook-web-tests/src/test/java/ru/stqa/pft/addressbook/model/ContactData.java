package ru.stqa.pft.addressbook.model;

public class ContactData {
    private final String firstName;
    private final String lastName;
    private final String nickName;
    private final String homePhone;
    private final String eMail;

    public ContactData(String firstName, String lastName, String nickName, String homePhone, String eMail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.homePhone = homePhone;
        this.eMail = eMail;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getEmail() {
        return eMail;
    }
}