package com.derekshao.AddressBookApplication;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Class containing all buddyinfos.
 *
 * @author Derek Shao
 */
@Entity
public class AddressBook {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    @OneToMany(mappedBy = "addressBook", cascade = CascadeType.ALL)
    private List<BuddyInfo> buddies;

    public AddressBook() {

        buddies = new ArrayList<BuddyInfo>();
    }

    public void addBuddy(BuddyInfo newBuddy) {

        buddies.add(newBuddy);
    }


    /**
     * Remove a buddy info object by name.
     *
     * @param name Name of the Buddy.
     * @return true if the buddy was found and removed, otherwise false.
     */
    public boolean removeBuddy(final String name) {

        final Iterator buddyIterator = buddies.iterator();

        while (buddyIterator.hasNext()) {


            BuddyInfo buddy = (BuddyInfo) buddyIterator.next();

            if (buddy.getName().equals(name)) {
                buddyIterator.remove();
                return true;
            }
        }

        return false;
    }

    public BuddyInfo replaceBuddyInfo(final int index, final BuddyInfo buddy) {

        return buddies.set(index, buddy);
    }

    public void printBuddies() {

        for (BuddyInfo info : buddies) {
            System.out.println("Buddy Name: " + info.getName());
            System.out.println("Phone Number: " + info.getPhoneNumber());
        }
    }

    public List<BuddyInfo> getBuddies() {
        return buddies;
    }

    public void setBuddies(List<BuddyInfo> buddies) {
        this.buddies = buddies;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
