package com.derekshao.AddressBookApplication;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AddressBookController.class)
public class MockAddressBookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AddressBookRepository addressBookRepository;

    @Test
    public void addressBookControllerTemplateWithMockedRepo() throws Exception {

        // testing data for address book template
        AddressBook addressBook = new AddressBook();
        BuddyInfo buddy1 = new BuddyInfo("buddy1", "address1", "1234567890");
        addressBook.addBuddy(buddy1);
        ArrayList<AddressBook> addressBooksList = new ArrayList<>();
        addressBooksList.add(addressBook);

        // mock repository behavior
        when(addressBookRepository.findAll()).thenReturn(addressBooksList);

        // check if the address book with buddy is present
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("buddy1")));
    }
}
