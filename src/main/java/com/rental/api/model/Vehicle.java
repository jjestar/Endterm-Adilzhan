package com.rental.api.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "vehicle_category")
@Data

@SQLDelete(sql = "UPDATE vehicle SET is_deleted = true WHERE id = ?")

@SQLRestriction("is_deleted = false")
public abstract class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String model;
    private double basePricePerDay;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted = false;

    public Vehicle() {}

    public Vehicle(String brand, String model, double basePricePerDay) {
        this.brand = brand;
        this.model = model;
        this.basePricePerDay = basePricePerDay;
        this.isDeleted = false;
    }
}