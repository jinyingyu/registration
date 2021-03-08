package com.cartrust.registration;

import com.fasterxml.jackson.annotation.JsonProperty;


public class VehicleRegistration {
    private String registrationID;

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    @JsonProperty("vehicleID")
    private String vehicleID;

    public String getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }

    @JsonProperty("ownerID")
    private String ownerID;

    public boolean isDocumentOK() {
        return isDocumentOK;
    }

    public void setDocumentOK(boolean documentOK) {
        isDocumentOK = documentOK;
    }

    @JsonProperty("isDocumentOK")
    private boolean isDocumentOK = false;

    public String getRegistrationID() {
        return registrationID;
    }

    public void setRegistrationID(String registrationID) {
        this.registrationID = registrationID;
    }

    public VehicleRegistration(){
    }
    public VehicleRegistration(String registrationID, String vehicleID, String ownerID){
        this.registrationID = registrationID;
        this.vehicleID = vehicleID;
        this.ownerID = ownerID;
    }


}
