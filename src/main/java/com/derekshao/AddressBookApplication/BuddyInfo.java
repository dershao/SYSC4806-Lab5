package com.derekshao.AddressBookApplication;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;

/**
 * Class containing information of a Buddy.
 *
 * @author Derek Shao
 */
@Entity
public class BuddyInfo {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name="addressBook_id")
    @RestResource(path = "addressBook", rel="addressBook")
    private AddressBook addressBook;

    public BuddyInfo() {

    }

    public BuddyInfo(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AddressBook getAddressBook() {
        return addressBook;
    }

    public void setAddressBook(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    @Override
    public String toString() {

        return String.format(
                "com.derekshao.AddressBookApplication.BuddyInfo[Name='%s', Phone Number='%s']",
                name, phoneNumber);
    }
}
