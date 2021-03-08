package com.cartrust.registration.vehicle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@WebFluxTest(controllers = {VehicleController.class})
class VehicleControllerTest {

    private List<Vehicle> vehicles;

    @BeforeEach
    void setUp() {
        vehicles = new ArrayList<>();
        vehicles.add(new Vehicle("someCarID1"));
        vehicles.add(new Vehicle("someCarID2"));
    }

    @Test
    void getAllRegistrations(@Autowired WebTestClient client) {

        final List<Vehicle> responsedVehs = client.get()
                .uri("/vehicles/all")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Vehicle.class)
                .returnResult()
                .getResponseBody();
        assertEquals(vehicles.get(1).getVehicleID(), responsedVehs.get(1).getVehicleID());
        assertEquals(vehicles.size(), responsedVehs.size());

    }

    @Test
    void register(@Autowired WebTestClient client) {
        Vehicle vehicle = new Vehicle("someCarID3");
        final Vehicle responsedReg = client.post()
                .uri("/vehicles/register")
                .bodyValue(vehicle)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(Vehicle.class)
                .returnResult()
                .getResponseBody();
        assertTrue(vehicle.getVehicleID().equals(responsedReg.getVehicleID()));

    }
}