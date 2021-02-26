package com.derekshao.AddressBookApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class AddressBookController {

    @Autowired
    private AddressBookRepository addressBookRepo;

//    @Autowired
//    private BuddyInfoRepository buddyInfoRepo;


    @GetMapping("/buddyinfo/form")
    public String buddyInfoForm(Model model) {
        model.addAttribute("buddyForm", new BuddyInfoFormData());

        return "buddyform";
    }

    @PostMapping("/buddyinfo/form")
    public String submitBuddyInfo(@ModelAttribute BuddyInfoFormData buddyForm, Model model) {
        model.addAttribute("buddyForm", buddyForm);

        saveBuddyInfo(buddyForm);

        return addressBook(model);
    }

    @GetMapping("/addressbook/form")
    public String addressBookForm(Model model) {
        model.addAttribute("addressBook", new AddressBook());

        return "addressBookForm";
    }

    @PostMapping("/addressbook/form")
    public String submitAddressBookForm(@ModelAttribute AddressBook addressBook, Model model) {

        model.addAttribute("addressBook", addressBook);

        addressBookRepo.save(addressBook);

        return addressBook(model);
    }

    @GetMapping("/home")
    public String addressBook(Model model) {

        Iterable<AddressBook> books = addressBookRepo.findAll();

        model.addAttribute("books", books);

        return "home";
    }

    @GetMapping("/homespa")
    public String addressBookSpa(Model model) {

        Iterable<AddressBook> books = addressBookRepo.findAll();

        model.addAttribute("books", books);

        return "homespa";
    }

    @GetMapping("/addressbook/all")
    public @ResponseBody List<AddressBook> getAllAddressBook() {

        List<AddressBook> addressBooks = new ArrayList<>();
        addressBookRepo.findAll().iterator().forEachRemaining(addressBooks::add);

        return addressBooks;
    }

    @PostMapping("/buddyinfo/post")
    public @ResponseBody String postBuddyInfo(@RequestBody BuddyInfoFormData buddyInfoFormData) {

        saveBuddyInfo(buddyInfoFormData);

        return "Success";
    }

    public void saveBuddyInfo(BuddyInfoFormData buddyInfoFormData) {
        Optional<AddressBook> addressBookQuery = addressBookRepo.findById(buddyInfoFormData.getAddressBookId());

        AddressBook addressBook;
        if (addressBookQuery.isPresent()) {
            addressBook = addressBookQuery.get();
        } else {
            addressBook = new AddressBook();
        }

        BuddyInfo newBuddyInfo = new BuddyInfo(buddyInfoFormData.getName(), buddyInfoFormData.getAddress(), buddyInfoFormData.getPhoneNumber());
        newBuddyInfo.setAddressBook(addressBook);

        addressBook.addBuddy(newBuddyInfo);

        addressBookRepo.save(addressBook);
    }
}
