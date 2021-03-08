package com.cartrust.registration.vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleRepository {

    private final List<Vehicle> repo;

    public VehicleRepository(){
        repo = new ArrayList<>();
        Vehicle aCar = new Vehicle();
        aCar.setCarID("someCarID1");
        aCar.setId(Integer.toString(repo.size()));
        aCar.setModel("mercedes");
        repo.add(aCar);

        Vehicle anotherCar = new Vehicle();
        anotherCar.setCarID("someCarID2");
        anotherCar.setId(Integer.toString(repo.size()));
        anotherCar.setModel("bmw");
        repo.add(anotherCar);

    }

    public Vehicle save(Vehicle aCar) {
        aCar.setId(Integer.toString(repo.size()));
        repo.add(aCar);
        return aCar;
    }

    public List<Vehicle> findAll() {
        return repo;
    }
}
