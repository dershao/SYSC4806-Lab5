package com.derekshao.AddressBookApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddressBookController {

    @Autowired
    private AddressBookRepository addressBookRepo;

    @Autowired
    private BuddyInfoRepository buddyInfoRepo;

    @GetMapping("/")
    public String addressBook(Model model) {

        Iterable<AddressBook> books = addressBookRepo.findAll();

        model.addAttribute("books", books);

        return "addressbook";
    }

//    @GetMapping("/addressbook/buddies")
//    public String buddies(Model model) {
//
//        buddyInfoRepo.findAll().forEach();
//    }
}
