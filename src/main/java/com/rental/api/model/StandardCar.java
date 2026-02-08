package com.rental.api.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@DiscriminatorValue("STANDARD")
@Data
@EqualsAndHashCode(callSuper = true)
public class StandardCar extends Vehicle {
    private boolean isFuelEfficient;

    public StandardCar() {}

    public StandardCar(String brand, String model, double price, boolean isFuelEfficient) {
        super(brand, model, price);
        this.isFuelEfficient = isFuelEfficient;
    }
}