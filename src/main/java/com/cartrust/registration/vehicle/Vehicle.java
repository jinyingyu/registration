package com.cartrust.registration.vehicle;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Vehicle {
    public Vehicle(String carID) {
        this.carID = carID;
    }

    public Vehicle() {

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    private String id;
    @JsonProperty("carID")
    private String carID;
    @JsonProperty("model")
    private String model;

}
