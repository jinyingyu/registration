package com.cartrust.registration.vehicle;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Vehicle {
    public Vehicle(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public Vehicle() {

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    private String id;
    @JsonProperty("vehicleID")
    private String vehicleID;
    @JsonProperty("model")
    private String model;

}
