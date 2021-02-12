package com.derekshao.AddressBookApplication;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.repository.CrudRepository;


@RepositoryRestResource(collectionResourceRel = "addressbook", path = "addressbook")
public interface AddressBookRepository extends CrudRepository<AddressBook, Long> {

}
