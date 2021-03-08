package com.cartrust.registration.vehicle;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
public class VehicleController {
    private final VehicleService service = new VehicleService();

    @GetMapping("/vehicles/all")
    public List<Vehicle> getAllVehicles() {
        return service.getAllVehicles();
    }

    @PostMapping("/vehicles/register")
    public ResponseEntity register(
            @RequestBody Vehicle vehicle) {
        Vehicle savedOwner = service.register(vehicle);
        return ResponseEntity
                .created(URI
                        .create(String.format("/vehicles/%s", vehicle.getId())))
                .body(savedOwner);
    }


}

