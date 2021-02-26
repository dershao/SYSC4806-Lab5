package com.derekshao.AddressBookApplication;

public class BuddyInfoFormData {

    private long id;
    private String name;
    private String phoneNumber;
    private String address;
    private long addressBookId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getAddressBookId() {
        return addressBookId;
    }

    public void setAddressBookId(long addressBookId) {
        this.addressBookId = addressBookId;
    }
}
