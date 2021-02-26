const Home = {

    setup: function() {

        let createAddressBook = $("#createAddressBook");
        createAddressBook.on("click", Home.showCreateAddressBookForm);

        let createBuddyInfo = $("#createBuddyInfo");
        createBuddyInfo.on("click", Home.showCreateBuddyInfoForm);

        let buddyInfoForm = $("#buddyInfoForm");
        buddyInfoForm.on("submit", Home.submitBuddyInfo);

        let addressBookForm = $("#addressBookForm");
        addressBookForm.on("submit", Home.submitAddressBook);
    },

    submitBuddyInfo: function() {


        let form = document.getElementById("buddyInfoForm");

        let formData = new FormData(form);

        let dataObject = {};

        for (let [key, prop] of formData) {
            dataObject[key] = prop;
        }

        let post_data = JSON.stringify(dataObject, null, 2);

        $.ajax({type: 'POST',
            contentType: "application/json",
            url: '/buddyinfo/post',
            data: post_data,
        }).then((data) => {

            Home.hideCreateBuddyInfoForm();

            Home.fetchAddressBook().then((data) => {
                Home.generateAddressBook(data);
            });
        });

        return false;
    },

    submitAddressBook: function() {

        let form = document.getElementById("addressBookForm");

        let formData = new FormData(form);

        let dataObject = {};

        for (let [key, prop] of formData) {
            dataObject[key] = prop;
        }

        let post_data = JSON.stringify(dataObject, null, 2);
        console.log(post_data);

        $.ajax({type: 'POST',
            dataType: 'json',
            contentType: "application/json",
            url: '/addressbook',
            data: post_data,
        }).then((data) => {

            Home.hideCreateAddressBookForm();

            Home.fetchAddressBook().then((data) => {

                Home.generateAddressBook(data);
            });
        });

        return false;
    },

    fetchAddressBook() {

        return $.ajax({type: 'GET',
            dataType: 'json',
            url: '/addressbook/all'
        }).then((data) => {

            return data;
        });
    },

    showCreateBuddyInfoForm() {

        let buddyInfoFormWrapper = document.getElementById("buddyInfoFormWrapper");
        buddyInfoFormWrapper.style.display = "block";

        return false;
    },

    showCreateAddressBookForm() {

        let addressBookFormWrapper = document.getElementById("addressBookFormWrapper");
        addressBookFormWrapper.style.display = "block";

        return false;
    },

    hideCreateAddressBookForm() {

        let addressBookFormWrapper = document.getElementById("addressBookFormWrapper");
        addressBookFormWrapper.style.display = "none";

        return false;
    },

    hideCreateBuddyInfoForm() {

        let buddyInfoFormWrapper = document.getElementById("buddyInfoFormWrapper");
        buddyInfoFormWrapper.style.display = "none";

        return false;
    },

    generateAddressBook(data) {

        $("table").empty();

        for (let i = 0; i < data.length; i++) {
            let addressBook = data[i];

            let bookRow = document.createElement("tr");
            let bookColumn = document.createElement("td");
            bookColumn.innerHTML = `Address book Name: ${addressBook.name}`;
            bookRow.appendChild(bookColumn);

            $("table").append(bookRow);

            console.log(addressBook);
            console.log(Object.keys(addressBook));


            if (addressBook.buddies.length > 0) {

                for (let i = 0; i < addressBook.buddies.length; i++) {
                    let buddies = addressBook.buddies[i];
                    let buddiesRow = document.createElement("tr");

                    let buddiesName = document.createElement("td");
                    buddiesName.innerHTML = buddies.name;
                    let buddiesAddress = document.createElement("td");
                    buddiesAddress.innerHTML = buddies.address;
                    let buddiesPhone = document.createElement("td");
                    buddiesPhone.innerHTML = buddies.phoneNumber;

                    buddiesRow.appendChild(buddiesName);
                    buddiesRow.appendChild(buddiesAddress);
                    buddiesRow.appendChild(buddiesPhone);

                    $("table").append(buddiesRow);
                }
            }

        }
    }
};

$(Home.setup);

