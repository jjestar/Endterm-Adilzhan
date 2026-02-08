package com.rental.api.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@DiscriminatorValue("LUXURY")
@Data
@EqualsAndHashCode(callSuper = true)
public class LuxuryCar extends Vehicle {
    private boolean chauffeurAvailable;

    public LuxuryCar() {}

    public LuxuryCar(String brand, String model, double price, boolean chauffeurAvailable) {
        super(brand, model, price);
        this.chauffeurAvailable = chauffeurAvailable;
    }
}