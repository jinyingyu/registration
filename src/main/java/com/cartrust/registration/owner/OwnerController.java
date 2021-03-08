package com.cartrust.registration.owner;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
public class OwnerController {
    private final OwnerService service = new OwnerService();

    @GetMapping("/owners/all")
    public List<Owner> getCurrentOwners() {
        return service.getAllOwners();
    }

    @PostMapping("/owners/register")
    public ResponseEntity addOwner(
            @RequestBody Owner owner) {
        Owner savedOwner = service.addOwner(owner);
        return ResponseEntity
                .created(URI
                        .create(String.format("/owner/%s", owner.getId())))
                .body(savedOwner);
    }


}

