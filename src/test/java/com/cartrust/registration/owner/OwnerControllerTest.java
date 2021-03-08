package com.cartrust.registration.owner;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@WebFluxTest(controllers = {OwnerController.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OwnerControllerTest {


    private List<Owner> owners;

    @BeforeEach
    void setUp(ApplicationContext context) {
        owners = new ArrayList<>();
        owners.add(new Owner("John Doe"));
        owners.add(new Owner("Jane Doe"));
    }

    @Test
    @Order(1)
    void getAllOwners(@Autowired WebTestClient client) {

        final List<Owner> responsedOwners = client.get()
                .uri("/owners/all")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Owner.class)
                .returnResult()
                .getResponseBody();
        assertTrue(owners.equals(responsedOwners));
        assertEquals(owners.size(), responsedOwners.size());

    }


    @Test
    @Order(100)
    void addOwner(@Autowired WebTestClient client) {
        Owner aMan = new Owner();
        aMan.setName("Alex");
        final Owner responsedOwner = client.post()
                .uri("/owners/register")
                .bodyValue(aMan)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(Owner.class)
                .returnResult()
                .getResponseBody();
        assertTrue(aMan.getName().equals(responsedOwner.getName()));
    }


}