package com.derekshao.AddressBookApplication;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "buddyinfo", path = "buddyinfo")
public interface BuddyInfoRepository extends PagingAndSortingRepository<BuddyInfo, Long> {

    List<BuddyInfo> findByName(@Param("name") final String name);
    List<BuddyInfo> findByPhoneNumber(@Param("phoneNumber") final String phoneNumber);
}