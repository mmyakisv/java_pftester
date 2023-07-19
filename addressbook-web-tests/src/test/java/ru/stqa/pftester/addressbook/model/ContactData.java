package ru.stqa.pftester.addressbook.model;

import java.util.Objects;

public class ContactData {

    public int id =  Integer.MAX_VALUE;
    private  String firstname;
    private  String lastname;
    private  String mobile;
    private  String email;
    private  String group;

    public int getId() {
        return id;
    }

    public ContactData withId(int id) {

        this.id = id;
        return this;
    }


    public ContactData withFirstName (String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData withLastName (String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withMobile (String mobile) {
        this.mobile = mobile;
        return this;
    }

    public ContactData withEmail (String email) {
        this.email = email;
        return this;
    }


    public ContactData withGroup (String group) {
        this.group = group;
        return this;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname);
    }
}
