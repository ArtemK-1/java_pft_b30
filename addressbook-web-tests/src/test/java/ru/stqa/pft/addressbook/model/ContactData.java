package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
    private int id;
    private final String firstName;
    private final String lastName;
    private final String nickName;
    private final String homePhone;
    private final String eMail;
    private String group;

    public ContactData(String firstName, String lastName, String nickName, String homePhone, String eMail, String group) {
        this.id = Integer.MAX_VALUE;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.homePhone = homePhone;
        this.eMail = eMail;
        this.group = group;
    }

    public ContactData(int id, String firstName, String lastName, String nickName, String homePhone, String eMail, String group) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.homePhone = homePhone;
        this.eMail = eMail;
        this.group = group;
    }

    public int getId() { return id; }

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

    public String getGroup() { return group; }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (!Objects.equals(firstName, that.firstName)) return false;
        return Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }
}