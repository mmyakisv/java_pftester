package model;

public record ContactData(String firstname, String lastname, String mobile, String email) {
    public ContactData() {
        this("", "", "", "");
    }


    public ContactData withFirstname(String firstname) {
        return new ContactData(firstname, this.lastname, this.mobile, this.email);
    }

    public ContactData withLastname(String lastname) {
        return new ContactData(this.firstname, lastname, this.mobile, this.email);
    }

    public ContactData withMobile(String mobile) {
        return new ContactData(this.firstname, this.lastname, mobile, this.email);
    }

    public ContactData withEmail(String email) {
        return new ContactData(this.firstname, this.lastname, this.mobile, email);
    }
}