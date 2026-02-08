package com.rental.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "vehicle_category")
@Data
public abstract class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private double basePricePerDay;

    public Vehicle() {}

    public Vehicle(String brand, String model, double basePricePerDay) {
        this.brand = brand;
        this.model = model;
        this.basePricePerDay = basePricePerDay;
    }
}