package com.derekshao.AddressBookApplication;

import com.fasterxml.jackson.annotation.*;
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
    private String address;

    @ManyToOne
    @JoinColumn(name="addressBook_id")
    @RestResource(path = "addressBook", rel="addressBook")
    @JsonIgnore
    private AddressBook addressBook;

    public BuddyInfo() {

    }

    public BuddyInfo(String name, String address, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {

        return String.format(
                "com.derekshao.AddressBookApplication.BuddyInfo[Name='%s', Address='%s', Phone Number='%s']",
                name, address, phoneNumber);
    }
}
