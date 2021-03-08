package com.cartrust.registration.owner;

import java.util.ArrayList;
import java.util.List;

public class OwnerRepository {

    private final List<Owner> repo;

    public OwnerRepository(){
        repo = new ArrayList<>();
        Owner aMan = new Owner();
        aMan.setName("John Doe");
        repo.add(aMan);

        Owner aWoman = new Owner();
        aWoman.setName("Jane Doe");
        repo.add(aWoman);

    }

    public Owner save(Owner owner) {
        owner.setId(Integer.toString(repo.size()));
        repo.add(owner);
        return owner;
    }

    public List<Owner> findAll() {
        return repo;
    }
}
