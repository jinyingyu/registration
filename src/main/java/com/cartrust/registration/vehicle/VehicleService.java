package com.cartrust.registration.vehicle;

import java.util.List;

public class VehicleService {

    private final VehicleRepository repo = new VehicleRepository();


    public List<Vehicle> getAllVehicles() {
        return repo.findAll();
    }

    public Vehicle register(Vehicle vehicle) {
        return repo.save(vehicle);
    }

}
