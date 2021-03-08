package com.cartrust.registration;

import java.util.ArrayList;
import java.util.List;

public class RegistrationRepository {
    private final List<VehicleRegistration> repo = new ArrayList<>();

    public List<VehicleRegistration> findAll(){
        return repo;
    }

    public VehicleRegistration save(VehicleRegistration reg){
        reg.setRegistrationID(Integer.toString(repo.size()));
        repo.add(reg);
        return reg;
    }

}
