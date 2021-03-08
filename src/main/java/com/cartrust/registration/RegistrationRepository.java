package com.cartrust.registration;

import java.util.ArrayList;
import java.util.List;

public class RegistrationRepository {
    private final List<VehicleRegistration> repo;

    public RegistrationRepository(){
        repo = new ArrayList<>();
        repo.add(new VehicleRegistration("0", "mercedes-c","John Doe"));
        repo.add(new VehicleRegistration("1", "bmw-x1","Jane Doe"));
    }

    public List<VehicleRegistration> findAll(){
        return repo;
    }

    public VehicleRegistration save(VehicleRegistration reg){
        reg.setRegistrationID(Integer.toString(repo.size()));
        repo.add(reg);
        return reg;
    }

}
