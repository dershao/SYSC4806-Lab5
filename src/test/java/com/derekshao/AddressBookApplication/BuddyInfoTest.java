package com.derekshao.AddressBookApplication;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BuddyInfoTest {


    @Test
    public void testBuddyInfo() {

        BuddyInfo buddy1 = new BuddyInfo("buddy1", "address", "1234567890");
        assertThat(buddy1.getName().equals("buddy1"));
        assertThat(buddy1.getAddress().equals("address"));
        assertThat(buddy1.getPhoneNumber().equals("1234567890"));
    }
}
