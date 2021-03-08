package com.cartrust.registration;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
public class RegistrationController {
    private final RegistrationService service = new RegistrationService();

    @GetMapping("/registrations/all")
    public List<VehicleRegistration> getAllRegistrations() {
        return service.getAllRegistrations();
    }

    @PostMapping("/registrations/register")
    public ResponseEntity register(
            @RequestBody VehicleRegistration registration) {
        VehicleRegistration savedRegistration = service.register(registration);
        if(savedRegistration == null) {return ResponseEntity.badRequest()
                .contentType(MediaType.APPLICATION_JSON).body("{\"result\": \"the document check is not passing\"}");}
        return ResponseEntity
                .created(URI
                        .create(String.format("/registrations/%s", savedRegistration.getRegistrationID())))
                .body(savedRegistration);
    }


}

