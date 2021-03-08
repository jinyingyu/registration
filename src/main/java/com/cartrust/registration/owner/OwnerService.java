package com.cartrust.registration.owner;

import java.util.List;

public class OwnerService {

    private final OwnerRepository owners = new OwnerRepository();


    public List<Owner> getAllOwners() {
        return owners.findAll();
    }

    public Owner register(Owner owner) {
        return owners.save(owner);
    }

}
