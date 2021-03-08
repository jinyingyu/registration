package com.cartrust.registration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@WebFluxTest(controllers = {RegistrationController.class})
class RegistrationControllerTest {

    private List<VehicleRegistration> regs;

    @BeforeEach
    void setUp() {
        regs = new ArrayList<>();
        regs.add(new VehicleRegistration("0", "mercedes-c", "John Doe"));
        regs.add(new VehicleRegistration("1", "bmw-x1", "Jane Doe"));

    }

    @Test
    void getAllRegistrations(@Autowired WebTestClient client) {

        final List<VehicleRegistration> responsedRegs = client.get()
                .uri("/registrations/all")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(VehicleRegistration.class)
                .returnResult()
                .getResponseBody();
        assertEquals(regs.get(1).getOwnerID(), responsedRegs.get(1).getOwnerID());
        assertEquals(regs.get(1).getVehicleID(), responsedRegs.get(1).getVehicleID());
        assertEquals(regs.size(), responsedRegs.size());

    }

    @Test
    void register(@Autowired WebTestClient client) {
        VehicleRegistration aReg = new VehicleRegistration("3","fiat", "Alexander Doe");
        final VehicleRegistration responsedReg = client.post()
                .uri("/registrations/register")
                .bodyValue(aReg)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(VehicleRegistration.class)
                .returnResult()
                .getResponseBody();
        assertTrue(aReg.getVehicleID().equals(responsedReg.getVehicleID()));

    }
}