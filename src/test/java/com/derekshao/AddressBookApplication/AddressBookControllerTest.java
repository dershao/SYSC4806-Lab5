package com.derekshao.AddressBookApplication;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AddressBookControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private AddressBookController addressBookController;

    private BuddyInfo buddyInfo = new BuddyInfo();

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/", String.class)
                .contains("Address Book"));
    }
}
