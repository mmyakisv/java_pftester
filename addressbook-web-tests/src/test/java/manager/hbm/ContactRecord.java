package manager.hbm;


import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "addressbook")

public class ContactRecord {

    @Id
    @Column(name = "id")
    public int id;

    @Column(name = "firstname")
    public String firstname;

    @Column(name = "lastname")
    public String lastname;

    @Column(name = "mobile")
    public String mobile;
    @Column(name = "email")
    public String email;
    @Column(name = "address")
    public String address;

    public Date deprecated = new Date();

//    @ManyToMany
//    @JoinTable(name = "address_in_groups",
//            inverseJoinColumns = @JoinColumn(name = "id"),
//
//    joinColumns = @JoinColumn(name = "group_id"))
//public List<GroupRecord> groups;

    @ManyToMany(mappedBy = "contacts")
   public List<GroupRecord> groups;


    public ContactRecord() {
    }

    public ContactRecord(int id, String firstname, String lastname, String mobile, String email, String address) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
    }
}
