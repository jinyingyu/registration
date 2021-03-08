package com.cartrust.registration;

import java.util.List;

public class RegistrationService {
    private final RegistrationRepository repo = new RegistrationRepository();

    public List<VehicleRegistration> getAllRegistrations() {
        return  repo.findAll();
    }

    public VehicleRegistration register(VehicleRegistration registration) {
        if (!registration.isDocumentOK()) return null;
        return repo.save(registration);
    }
}
