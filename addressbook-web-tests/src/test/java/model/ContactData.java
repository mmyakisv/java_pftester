package model;

public record ContactData(String id, String firstname, String lastname, String mobile, String email, String address) {
    public ContactData() {
        this("","", "", "", "", "");
    }
    public ContactData withId(String id) {
        return new ContactData(id, this.firstname, this.lastname, this.mobile, this.email, this.address);
    }

    public ContactData withFirstname(String firstname) {
        return new ContactData(this.id, firstname, this.lastname, this.mobile, this.email, this.address);
    }

    public ContactData withLastname(String lastname) {
        return new ContactData(this.id, this.firstname, lastname, this.mobile, this.email, this.address);
    }

    public ContactData withMobile(String mobile) {
        return new ContactData(this.id, this.firstname, this.lastname, mobile, this.email,this.address);
    }

    public ContactData withEmail(String email) {
        return new ContactData(this.id, this.firstname, this.lastname, this.mobile, this.address, email);
    }
    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.firstname, this.lastname, this.mobile, this.email, address);
    }
}